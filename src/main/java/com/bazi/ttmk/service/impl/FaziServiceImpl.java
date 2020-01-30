package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.Faza;
import com.bazi.ttmk.repository.FaziRepository;
import com.bazi.ttmk.service.FaziService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaziServiceImpl implements FaziService {
    private final FaziRepository faziRepository;

    public FaziServiceImpl(FaziRepository faziRepository) {
        this.faziRepository = faziRepository;
    }

    @Override
    public List<Faza> getAllFazi() {
        return this.faziRepository.findAll();
    }
}
