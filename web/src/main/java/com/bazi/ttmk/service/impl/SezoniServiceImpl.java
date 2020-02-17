package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.Liga;
import com.bazi.ttmk.model.Sezona;
import com.bazi.ttmk.model.Turnir;
import com.bazi.ttmk.repository.SezoniRepository;
import com.bazi.ttmk.service.SezoniService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SezoniServiceImpl implements SezoniService {

    private final SezoniRepository sezoniRepository;

    public SezoniServiceImpl(SezoniRepository sezoniRepository) {
        this.sezoniRepository = sezoniRepository;
    }

    @Override
    public List<Sezona> getAllSezoni() {
        return this.sezoniRepository.findAll();
    }

    @Override
    public Sezona createSezona(String godina, String pretsedatel) {
        Sezona sezona = new Sezona();
        sezona.setGodina(godina);
        sezona.setPretsedatel(pretsedatel);
        return this.sezoniRepository.save(sezona);
    }

    public List<Liga> getAllLigiInSezona(int idSezona) {
        Sezona s = this.sezoniRepository.findById(idSezona)
                .orElseThrow(() -> new RuntimeException("No sezona found with " + idSezona + " id"));
        return s.getLigi() == null ? Collections.emptyList() : s.getLigi();
    }

    @Override
    public List<Turnir> getAllTurniriInSezona(int idSezona) {
        Sezona s = this.sezoniRepository.findById(idSezona)
                .orElseThrow(() -> new RuntimeException("No sezona found with " + idSezona + " id"));
        return s.getTurniri() == null ? Collections.emptyList() : s.getTurniri();
    }

}
