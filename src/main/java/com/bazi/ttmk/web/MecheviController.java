package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Mech;
import com.bazi.ttmk.service.MecheviService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/mechevi")
public class MecheviController {
    private final MecheviService mecheviService;

    public MecheviController(MecheviService mecheviService) {
        this.mecheviService = mecheviService;
    }

    @GetMapping
    public List<Mech> findAll() {
        return this.mecheviService.getAllMechevi();
    }
}
