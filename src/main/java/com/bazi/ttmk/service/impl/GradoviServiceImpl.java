package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.Grad;
import com.bazi.ttmk.repository.GradoviRepository;
import com.bazi.ttmk.service.GradoviService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradoviServiceImpl implements GradoviService {
    private final GradoviRepository gradoviRepository;

    public GradoviServiceImpl(GradoviRepository gradoviRepository) {
        this.gradoviRepository = gradoviRepository;
    }

    @Override
    public List<Grad> getAllGradovi() {
        return this.gradoviRepository.findAll();
    }
}
