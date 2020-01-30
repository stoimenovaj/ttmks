package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Spagja;
import com.bazi.ttmk.repository.SpagjaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/spagja")
public class SpagjaController {
    private final SpagjaRepository spagjaRepository;

    public SpagjaController(SpagjaRepository spagjaRepository) {
        this.spagjaRepository = spagjaRepository;
    }

    @GetMapping
    public List<Spagja> findAll() { return this.spagjaRepository.findAll(); }
}
