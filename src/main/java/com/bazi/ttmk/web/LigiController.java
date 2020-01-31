package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Liga;
import com.bazi.ttmk.service.LigiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/ligi")
public class LigiController {
    private final LigiService ligiService;

    public LigiController(LigiService ligiService) {
        this.ligiService = ligiService;
    }

    @GetMapping
    public List<Liga> findAll() {
        return this.ligiService.getAllLigi();
    }

    @PostMapping
    public Liga createLiga(int idSezona,
                           String imeLiga){
        return this.ligiService.createLiga(idSezona,imeLiga);
    }
}
