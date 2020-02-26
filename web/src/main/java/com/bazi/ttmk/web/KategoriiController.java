package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Kategorija;
import com.bazi.ttmk.service.KategoriiService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/kategorii")
@CrossOrigin(origins = "http://localhost:3000")
public class KategoriiController {
    private final KategoriiService kategoriiService;

    public KategoriiController(KategoriiService kategoriiService) {
        this.kategoriiService = kategoriiService;
    }

    @GetMapping
    public List<Kategorija> findAll() {
        return this.kategoriiService.getAllKategorii();
    }

    @PostMapping
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public Kategorija createKategorija(String imeKategorija){
        return this.kategoriiService.createKategorija(imeKategorija);
    }
}
