package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.Grad;
import com.bazi.ttmk.model.Sala;
import com.bazi.ttmk.repository.GradoviRepository;
import com.bazi.ttmk.repository.SaliRepository;
import com.bazi.ttmk.service.SaliService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaliServiceImpl implements SaliService {

    private final SaliRepository saliRepository;

    private final GradoviRepository gradoviRepository;

    public SaliServiceImpl(SaliRepository saliRepository, GradoviRepository gradoviRepository) {
        this.saliRepository = saliRepository;
        this.gradoviRepository = gradoviRepository;
    }

    @Override
    public List<Sala> getAllSali() {
        return this.saliRepository.findAll();
    }

    @Override
    public Sala createSala(String imeSala, Integer idGrad) {
        Grad grad = this.gradoviRepository.findById(idGrad).orElseThrow(() -> new RuntimeException("Gradot with id " + idGrad + " not found"));
        Sala sala = new Sala();
        sala.setImeSala(imeSala);
        sala.setGrad(grad);
        return this.saliRepository.save(sala);
    }
}
