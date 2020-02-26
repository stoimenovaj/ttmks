package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Spagja;
import com.bazi.ttmk.service.SpagjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/spagja")
@CrossOrigin(origins = "http://localhost:3000")
public class SpagjaController {
    private final SpagjaService spagjaService;

    public SpagjaController(SpagjaService spagjaService) {
        this.spagjaService = spagjaService;
    }

    @GetMapping
    public List<Spagja> findAll() {
        return this.spagjaService.getAllSpagja();
    }

    @PostMapping
    public Spagja createSpagja(Integer idSezona,
                               Integer idLiga,
                               Integer idTim,
                               Integer timPoeni) {
        return this.spagjaService.createSpagja(idSezona, idLiga, idTim, timPoeni);
    }
}
