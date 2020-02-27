package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.*;
import com.bazi.ttmk.model.dto.LigiWithTimovi;
import com.bazi.ttmk.model.Faza;
import com.bazi.ttmk.model.Turnir;
import com.bazi.ttmk.model.TurnirId;
import com.bazi.ttmk.model.dto.FazaInTurnir;
import com.bazi.ttmk.model.dto.IgrachInMech;
import com.bazi.ttmk.model.dto.IgrachiInTurnirMech;
import com.bazi.ttmk.model.utils.DetaliFaza;
import com.bazi.ttmk.repository.*;
import com.bazi.ttmk.service.TurniriService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TurniriServiceImpl implements TurniriService {

    private final TurniriRepository turniriRepository;
    private final SezoniRepository sezoniRepository;
    private final SaliRepository saliRepository;
    private final FaziRepository faziRepository;
    private final KategoriiRepository kategoriiRepository;
    private final SpagjaRepository spagjaRepository;
    private final LigiRepository ligiRepository;
    private final TimoviRepository timoviRepository;

    public TurniriServiceImpl(TurniriRepository turniriRepository, SezoniRepository sezoniRepository, SaliRepository saliRepository, FaziRepository faziRepository, KategoriiRepository kategoriiRepository, SpagjaRepository spagjaRepository, LigiRepository ligiRepository, TimoviRepository timoviRepository) {
        this.turniriRepository = turniriRepository;
        this.sezoniRepository = sezoniRepository;
        this.saliRepository = saliRepository;
        this.faziRepository = faziRepository;
        this.kategoriiRepository = kategoriiRepository;
        this.spagjaRepository = spagjaRepository;
        this.ligiRepository = ligiRepository;
        this.timoviRepository = timoviRepository;
    }


    @Override
    public List<Turnir> getAllTurniri() {
        return this.turniriRepository.findAll();
    }

    private List<Faza> createFaziForTurnir(Turnir t, int brIgrachi) {
        int brFazi = (int) (Math.log(brIgrachi) / Math.log(2));

        List<Faza> fazi = new ArrayList<>();

        for (int i = 1; i <= brFazi; i++) {
            Faza f = new Faza();

            f.setIdTurnir(t.getIdTurnir());
            f.setIdKategorija(t.getIdKategorija());

            int tmp = i;
            DetaliFaza detaliFaza = Arrays.stream(DetaliFaza.values())
                    .filter(opf -> opf.getBroj() == tmp)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No opis for faza"));

            f.setOpisFaza(detaliFaza.getOpis());
            f.setBrojFaza(detaliFaza.getBroj());
            f.setTurnir(t);

            fazi.add(this.faziRepository.saveAndFlush(f));
        }

        return fazi;
    }

    @Override
    public Turnir createTurnir(int idSezona, int idKategorija, String ime, Date data, int participacija, int idSala, int brIgrachi) {
        Turnir t = new Turnir();

        t.setIdKategorija(idKategorija);
        t.setSezona(this.sezoniRepository.findById(idSezona)
                .orElseThrow(() -> new RuntimeException("No season with " + idSezona + " found")));
        t.setImeTurnir(ime);
        t.setDataNaOdrzhuvanje(data);
        t.setParticipacija(participacija);
        t.setSalaNaOdrzuvanje(this.saliRepository.findById(idSala)
                .orElseThrow(() -> new RuntimeException("No sala with " + idSala + " id found")));
        t.setKategorija(this.kategoriiRepository.findById(idKategorija)
                .orElseThrow(() -> new RuntimeException("No kateorija with " + idKategorija + " id found")));


        t = this.turniriRepository.save(t);

        List<Faza> fazi = this.createFaziForTurnir(t, brIgrachi);
        t.setFazi(fazi);

        return this.turniriRepository.save(t);
    }

    @Override
    public Optional<Turnir> findTurnir(Integer idTurnir, Integer idKategorija) {
        return this.turniriRepository.findById(new TurnirId(idTurnir, idKategorija));
    }

    @Override
    public IgrachiInTurnirMech getFinale(int idTurnir, int idKategorija) {
        Faza finale = this.faziRepository.findByIdTurnirAndIdKategorijaAndBrojFaza(idTurnir, idKategorija, 1);

        return finale.getMechevi().stream()
                .findFirst()
                .map(mech -> new IgrachiInTurnirMech(
                        new IgrachiInTurnirMech.IgrachInTurnir(
                                mech.getDomakjinIgrach().getIdLice(),
                                mech.getDomakjinIgrach().getLice().getImeLice(),
                                mech.getDobieniSetoviDomakjin()
                        ),
                        new IgrachiInTurnirMech.IgrachInTurnir(
                                mech.getGostinIgrach().getIdLice(),
                                mech.getGostinIgrach().getLice().getImeLice(),
                                mech.getDobieniSetoviGostin()
                        ),
                        1,
                        true
                )).orElseThrow(() -> new RuntimeException("No mech found"));
    }

    @Override
    public List<LigiWithTimovi> findLigiWithTimovi(int idSezona) {
        List<Spagja> spagja = this.spagjaRepository.findByIdSezona(idSezona);
        Map<Integer, List<Spagja>> mapa = spagja.stream().collect(Collectors.groupingBy(Spagja::getIdLiga));
        return mapa.entrySet().stream()
                .map(entry -> {
                    Liga liga = this.ligiRepository.findById(new LigaId(entry.getKey(), idSezona)).get();
                    List<LigiWithTimovi.TimInfo> timovi = this.timoviRepository.findAllById(entry.getValue().stream()
                            .map(Spagja::getIdTim).collect(Collectors.toList())).stream()
                            .map(tim -> {
                                return new LigiWithTimovi.TimInfo(tim.getIdTim(), tim.getImeTim(), tim.getGrad().getImeGrad());
                            }).collect(Collectors.toList());

                    return new LigiWithTimovi(liga.getIdLiga(), liga.getImeLiga(), timovi);
                }).collect(Collectors.toList());
    }


    @Override
    public List<FazaInTurnir> getFaziForTurnir(int idTurnir, int idKategorija) {
        return this.faziRepository.findByIdTurnirAndIdKategorija(idTurnir, idKategorija).stream()
                .map(faza -> {
                    List<FazaInTurnir.MechInFaza> mechevi = faza.getMechevi().stream()
                            .map(mech -> {
                                return new FazaInTurnir.MechInFaza(
                                        new IgrachInMech(
                                                mech.getDomakjinIgrach().getIdLice(),
                                                mech.getDomakjinIgrach().getLice().getImeLice(),
                                                mech.getDomakjinIgrach().getLice().getPrezimeLice(),
                                                mech.getDobieniSetoviDomakjin()
                                        ),
                                        new IgrachInMech(
                                                mech.getGostinIgrach().getIdLice(),
                                                mech.getGostinIgrach().getLice().getImeLice(),
                                                mech.getGostinIgrach().getLice().getPrezimeLice(),
                                                mech.getDobieniSetoviGostin()
                                        ),
                                        mech.getSetovi().stream()
                                                .map(set -> new FazaInTurnir.MechInFaza.SetInMech(
                                                        set.getPoeniDomakjin(),
                                                        set.getPoeniGostin()
                                                )).collect(Collectors.toList())
                                );
                            }).collect(Collectors.toList());
                    return new FazaInTurnir(
                            faza.getBrojFaza(),
                            faza.getOpisFaza(),
                            mechevi
                    );
                })
                .sorted(Comparator.comparingInt(FazaInTurnir::getBroj))
                .collect(Collectors.toList());
    }
}
