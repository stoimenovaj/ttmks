package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Kategorija;
import com.bazi.ttmk.service.KategoriiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/kategorii")
public class KategoriiController {
    private final KategoriiService kategoriiService;

    public KategoriiController(KategoriiService kategoriiService) {
        this.kategoriiService = kategoriiService;
    }

    @GetMapping
    public List<Kategorija> findAll() {
        return this.kategoriiService.getAllKategorii();
    }
}
