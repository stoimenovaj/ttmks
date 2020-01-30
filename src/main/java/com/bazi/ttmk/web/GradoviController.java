package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Gradovi;
import com.bazi.ttmk.repository.GradoviRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/gradovi")
public class GradoviController {
    private final GradoviRepository gradoviRepository;

    public GradoviController(GradoviRepository gradoviRepository) {
        this.gradoviRepository = gradoviRepository;
    }

    @GetMapping
    public List<Gradovi> findAll(){ return this.gradoviRepository.findAll(); }
}
