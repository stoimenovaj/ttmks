package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Tim;
import com.bazi.ttmk.service.TimoviService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/timovi")
public class TimoviController {
    private final TimoviService timoviService;

    public TimoviController(TimoviService timoviService) {
        this.timoviService = timoviService;
    }

    @GetMapping
    public List<Tim> findAll() {
        return this.timoviService.getAllTimovi();
    }

    @PostMapping
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public Tim creatTim(Integer idGrad,
                        String imeTim,
                        Integer godinaOsnovan,
                        String kontaktEmail,
                        String kontaktLice,
                        String kontaktTelefon) {
        return this.timoviService.createTim(idGrad, imeTim, godinaOsnovan, kontaktEmail, kontaktLice, kontaktTelefon);
    }
}
