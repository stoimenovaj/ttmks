package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Kategorija;
import com.bazi.ttmk.repository.KategoriiRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/kategorii")
public class KategoriiController {
    private final KategoriiRepository kategoriiRepository;

    public KategoriiController(KategoriiRepository kategoriiRepository) {
        this.kategoriiRepository = kategoriiRepository;
    }

    @GetMapping
    public List<Kategorija> findAll() { return this.kategoriiRepository.findAll(); }
}
