package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Sala;
import com.bazi.ttmk.repository.SaliRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/sali")
public class SaliController {
    private final SaliRepository saliRepository;

    public SaliController(SaliRepository saliRepository) {
        this.saliRepository = saliRepository;
    }

    @GetMapping
    public List<Sala> getAllSali() { return this.saliRepository.findAll(); }
}