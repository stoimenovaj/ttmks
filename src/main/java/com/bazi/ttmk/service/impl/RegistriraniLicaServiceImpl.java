package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.Grad;
import com.bazi.ttmk.model.RegistriranoLice;
import com.bazi.ttmk.repository.GradoviRepository;
import com.bazi.ttmk.repository.RegistriraniLicaRepository;
import com.bazi.ttmk.service.RegistriraniLicaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistriraniLicaServiceImpl implements RegistriraniLicaService {

    private final RegistriraniLicaRepository registriraniLicaRepository;

    private final GradoviRepository gradoviRepository;

    public RegistriraniLicaServiceImpl(RegistriraniLicaRepository registriraniLicaRepository, GradoviRepository gradoviRepository) {
        this.registriraniLicaRepository = registriraniLicaRepository;
        this.gradoviRepository = gradoviRepository;
    }

    @Override
    public List<RegistriranoLice> getAllRegistriraniLica() {
        return this.registriraniLicaRepository.findAll();
    }

    @Override
    public RegistriranoLice createRegistriranoLice(String imeLice, String prezimeLice, int godiniLice, Integer idGrad) {
        Grad grad = this.gradoviRepository.findById(idGrad).orElseThrow(() -> new RuntimeException("Gradot with id " + idGrad + " not found"));
        RegistriranoLice registriranoLice = new RegistriranoLice();
        registriranoLice.setImeLice(imeLice);
        registriranoLice.setPrezimeLice(prezimeLice);
        registriranoLice.setGodiniLice(godiniLice);
        registriranoLice.setGradRaganje(grad);
        return this.registriraniLicaRepository.save(registriranoLice);
    }
}
