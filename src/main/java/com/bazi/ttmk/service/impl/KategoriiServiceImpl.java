package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.Kategorija;
import com.bazi.ttmk.repository.KategoriiRepository;
import com.bazi.ttmk.service.KategoriiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KategoriiServiceImpl implements KategoriiService {
    private final KategoriiRepository kategoriiRepository;

    public KategoriiServiceImpl(KategoriiRepository kategoriiRepository) {
        this.kategoriiRepository = kategoriiRepository;
    }

    @Override
    public List<Kategorija> getAllKategorii() {
        return this.kategoriiRepository.findAll();
    }

    @Override
    public Kategorija createKategorija(String imeKategorija) {
        Kategorija kategorija = new Kategorija();
        kategorija.setImeKategorija(imeKategorija);
        return this.kategoriiRepository.save(kategorija);
    }
}
