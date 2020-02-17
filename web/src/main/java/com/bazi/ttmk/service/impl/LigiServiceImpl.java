package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.Liga;
import com.bazi.ttmk.model.Natprevar;
import com.bazi.ttmk.model.Spagja;
import com.bazi.ttmk.model.Tim;
import com.bazi.ttmk.model.dto.NatprevarInLiga;
import com.bazi.ttmk.model.dto.TopListTeamStats;
import com.bazi.ttmk.repository.LigiRepository;
import com.bazi.ttmk.repository.NatprevariRepository;
import com.bazi.ttmk.repository.SpagjaRepository;
import com.bazi.ttmk.repository.TimoviRepository;
import com.bazi.ttmk.service.LigiService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LigiServiceImpl implements LigiService {

    private final LigiRepository ligiRepository;
    private final NatprevariRepository natprevariRepository;
    private final SpagjaRepository spagjaRepository;
    private final TimoviRepository timoviRepository;

    public LigiServiceImpl(LigiRepository ligiRepository, NatprevariRepository natprevariRepository, SpagjaRepository spagjaRepository, TimoviRepository timoviRepository) {
        this.ligiRepository = ligiRepository;
        this.natprevariRepository = natprevariRepository;
        this.spagjaRepository = spagjaRepository;
        this.timoviRepository = timoviRepository;
    }

    @Override
    public List<Liga> getAllLigi() {
        return this.ligiRepository.findAll();
    }

    @Override
    public Liga createLiga(int idSezona, String imeLiga) {
        Liga liga = new Liga();
        liga.setIdSezona(idSezona);
        liga.setImeLiga(imeLiga);
        return this.ligiRepository.save(liga);
    }

    public List<TopListTeamStats> topLista(int idSezona, int idLiga) {
        List<TopListTeamStats> rv = new ArrayList<>();

        List<Spagja> topLista = this.spagjaRepository.findByIdSezonaAndIdLigaOrderByTimPoeniDesc(idSezona, idLiga);

        for(Spagja spg : topLista){
            TopListTeamStats tlts = new TopListTeamStats();

            Tim tim = this.timoviRepository.findById(spg.getIdTim())
                    .orElseThrow(() -> new RuntimeException("No tim found with " + spg.getIdTim() + " id"));
            tlts.setIdTim(tim.getIdTim());
            tlts.setImeTim(tim.getImeTim());
            tlts.setBodovi(spg.getTimPoeni());

            int odigrani = this.natprevariRepository.odigraniNatprevari(idSezona, idLiga, tim.getIdTim()).orElse(0);
            int pobedi = this.natprevariRepository.pobedeniNatprevariDomakjin(idSezona, idLiga, tim.getIdTim()).orElse(0)
                    + this.natprevariRepository.pobedeniNatprevariGostin(idSezona, idLiga, tim.getIdTim()).orElse(0);
            int porazi = odigrani - pobedi;
            tlts.setOdigraniNatprevari(odigrani);
            tlts.setPobedi(pobedi);
            tlts.setPorazi(porazi);

            int dobieniMechevi = this.natprevariRepository.brojDomakjinOsvoeniMechevi(idSezona, idLiga, tim.getIdTim()).orElse(0)
                    + this.natprevariRepository.brojGostinOsvoeniMechevi(idSezona, idLiga, tim.getIdTim()).orElse(0);
            int izgubeniMechevi = this.natprevariRepository.brojDomakjinIzgubeniMechevi(idSezona, idLiga, tim.getIdTim()).orElse(0)
                    + this.natprevariRepository.brojGostinIzgubeniMechevi(idSezona, idLiga, tim.getIdTim()).orElse(0);
            tlts.setDobieniMechevi(dobieniMechevi);
            tlts.setIzgubeniMechevi(izgubeniMechevi);

            rv.add(tlts);
        }

        return rv;
    }

    @Override
    public List<NatprevarInLiga> getAllNatprevariVoLiga(int idSezona, int idLiga) {
        return this.natprevariRepository.findByLiga_IdSezonaAndLiga_IdLigaOrderByKolo(idSezona, idLiga)
                .stream()
                .collect(Collectors.groupingBy(Natprevar::getKolo))
                .entrySet()
                .stream()
                .map(entry -> new NatprevarInLiga(entry.getKey(),
                        entry.getValue()
                                .stream()
                                .map(nat -> {
                                    return new NatprevarInLiga.NatprevarInfo(
                                            nat.getIdNatprevar(),
                                            nat.getTimDomakjin().getIdTim(),
                                            nat.getTimDomakjin().getImeTim(),
                                            nat.getTimGostin().getIdTim(),
                                            nat.getTimGostin().getImeTim(),
                                            nat.getDobieniMecheviDomakjin(),
                                            nat.getDobieniMecheviGostin()
                                    );
                                })
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

}
