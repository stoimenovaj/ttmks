package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.Sala;
import com.bazi.ttmk.repository.SaliRepository;
import com.bazi.ttmk.service.SaliService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaliServiceImpl implements SaliService {
    private final SaliRepository saliRepository;

    public SaliServiceImpl(SaliRepository saliRepository) {
        this.saliRepository = saliRepository;
    }

    @Override
    public List<Sala> getAllSali() {
        return this.saliRepository.findAll();
    }
}
