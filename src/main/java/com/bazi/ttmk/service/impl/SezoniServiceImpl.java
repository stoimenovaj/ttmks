package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.Sezona;
import com.bazi.ttmk.repository.SezoniRepository;
import com.bazi.ttmk.service.SezoniService;
import org.springframework.stereotype.Service;

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
}
