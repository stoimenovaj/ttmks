package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Mech;
import com.bazi.ttmk.repository.MecheviRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/mechevi")
public class MecheviController {
    private final MecheviRepository mecheviRepository;

    public MecheviController(MecheviRepository mecheviRepository) {
        this.mecheviRepository = mecheviRepository;
    }

    @GetMapping
    public List<Mech> findAll() { return this.mecheviRepository.findAll(); }
}
