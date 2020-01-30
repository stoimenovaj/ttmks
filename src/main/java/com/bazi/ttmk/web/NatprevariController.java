package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Natprevar;
import com.bazi.ttmk.repository.NatprevariRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/natprevari")
public class NatprevariController {
    private final NatprevariRepository natprevariRepository;

    public NatprevariController(NatprevariRepository natprevariRepository) {
        this.natprevariRepository = natprevariRepository;
    }

    @GetMapping
    public List<Natprevar> findAll() { return this.natprevariRepository.findAll(); }
}
