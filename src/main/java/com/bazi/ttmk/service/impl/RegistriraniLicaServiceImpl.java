package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.RegistriranoLice;
import com.bazi.ttmk.repository.RegistriraniLicaRepository;
import com.bazi.ttmk.service.RegistriraniLicaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistriraniLicaServiceImpl implements RegistriraniLicaService {
    private final RegistriraniLicaRepository registriraniLicaRepository;

    public RegistriraniLicaServiceImpl(RegistriraniLicaRepository registriraniLicaRepository) {
        this.registriraniLicaRepository = registriraniLicaRepository;
    }

    @Override
    public List<RegistriranoLice> getAllRegistriraniLica() {
        return this.registriraniLicaRepository.findAll();
    }
}
