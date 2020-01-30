package com.bazi.ttmk.web;

import com.bazi.ttmk.model.RegistriranoLice;
import com.bazi.ttmk.service.RegistriraniLicaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/registriraniLica")
public class RegistriraniLicaController {
    private final RegistriraniLicaService registriraniLicaService;

    public RegistriraniLicaController(RegistriraniLicaService registriraniLicaService) {
        this.registriraniLicaService = registriraniLicaService;
    }

    @GetMapping
    public List<RegistriranoLice> findAll() {
        return this.registriraniLicaService.getAllRegistriraniLica();
    }
}
