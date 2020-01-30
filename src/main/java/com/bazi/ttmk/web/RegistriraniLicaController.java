package com.bazi.ttmk.web;

import com.bazi.ttmk.model.RegistriranoLice;
import com.bazi.ttmk.repository.RegistriraniLicaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/registriraniLica")
public class RegistriraniLicaController {
    private final RegistriraniLicaRepository registriraniLicaRepository;

    public RegistriraniLicaController(RegistriraniLicaRepository registriraniLicaRepository) {
        this.registriraniLicaRepository = registriraniLicaRepository;
    }

    @GetMapping
    public List<RegistriranoLice> findAll() { return this.registriraniLicaRepository.findAll(); }
}
