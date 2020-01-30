package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.Spagja;
import com.bazi.ttmk.repository.SpagjaRepository;
import com.bazi.ttmk.service.SpagjaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpagjaServiceImpl implements SpagjaService {
    private final SpagjaRepository spagjaRepository;

    public SpagjaServiceImpl(SpagjaRepository spagjaRepository) {
        this.spagjaRepository = spagjaRepository;
    }

    @Override
    public List<Spagja> getAllSpagja() {
        return this.spagjaRepository.findAll();
    }
}
