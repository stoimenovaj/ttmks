package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.Set;
import com.bazi.ttmk.repository.SetoviRepository;
import com.bazi.ttmk.service.SetoviService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetoviServiceImpl implements SetoviService {
    private final SetoviRepository setoviRepository;

    public SetoviServiceImpl(SetoviRepository setoviRepository) {
        this.setoviRepository = setoviRepository;
    }

    @Override
    public List<Set> getAllSetovi() {
        return this.setoviRepository.findAll();
    }
}
