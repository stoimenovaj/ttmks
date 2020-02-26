package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.Faza;
import com.bazi.ttmk.model.Turnir;
import com.bazi.ttmk.model.TurnirId;
import com.bazi.ttmk.model.utils.DetaliFaza;
import com.bazi.ttmk.repository.*;
import com.bazi.ttmk.service.TurniriService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurniriServiceImpl implements TurniriService {

    private final TurniriRepository turniriRepository;
    private final SezoniRepository sezoniRepository;
    private final SaliRepository saliRepository;
    private final FaziRepository faziRepository;
    private final KategoriiRepository kategoriiRepository;

    public TurniriServiceImpl(TurniriRepository turniriRepository, SezoniRepository sezoniRepository, SaliRepository saliRepository, FaziRepository faziRepository, KategoriiRepository kategoriiRepository) {
        this.turniriRepository = turniriRepository;
        this.sezoniRepository = sezoniRepository;
        this.saliRepository = saliRepository;
        this.faziRepository = faziRepository;
        this.kategoriiRepository = kategoriiRepository;
    }


    @Override
    public List<Turnir> getAllTurniri() {
        return this.turniriRepository.findAll();
    }

    private List<Faza> createFaziForTurnir(Turnir t, int brIgrachi){
        int brFazi = (int) (Math.log(brIgrachi) / Math.log(2));

        List<Faza> fazi = new ArrayList<>();

        for(int i=1; i<=brFazi; i++){
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
}
