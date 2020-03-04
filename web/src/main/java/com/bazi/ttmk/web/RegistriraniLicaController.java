package com.bazi.ttmk.web;

import com.bazi.ttmk.model.RegistriranoLice;
import com.bazi.ttmk.service.RegistriraniLicaService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/registriraniLica")
@CrossOrigin(origins = "http://localhost:3000")
public class RegistriraniLicaController {

    private final RegistriraniLicaService registriraniLicaService;

    public RegistriraniLicaController(RegistriraniLicaService registriraniLicaService) {
        this.registriraniLicaService = registriraniLicaService;
    }

    @GetMapping
    public List<RegistriranoLice> findAll() {
        return this.registriraniLicaService.getAllRegistriraniLica();
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public RegistriranoLice createRegistriranoLice(String imeLice,
                                                   String prezimeLice,
                                                   int godiniLice,
                                                   Integer idGrad) {
        return this.registriraniLicaService.createRegistriranoLice(imeLice, prezimeLice, godiniLice, idGrad);

    }
}
