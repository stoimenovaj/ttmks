package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.Sudija;
import com.bazi.ttmk.repository.SudiiRepository;
import com.bazi.ttmk.service.SudiiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SudiiServiceImpl implements SudiiService {
    private final SudiiRepository sudiiRepository;

    public SudiiServiceImpl(SudiiRepository sudiiRepository) {
        this.sudiiRepository = sudiiRepository;
    }

    @Override
    public List<Sudija> getAllSudii() {
        return this.sudiiRepository.findAll();
    }
}
