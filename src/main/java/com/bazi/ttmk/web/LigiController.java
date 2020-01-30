package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Liga;
import com.bazi.ttmk.repository.LigiRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/ligi")
public class LigiController {
    private final LigiRepository ligiRepository;

    public LigiController(LigiRepository ligiRepository) {
        this.ligiRepository = ligiRepository;
    }

    @GetMapping
    public List<Liga> findAll() { return this.ligiRepository.findAll(); }
}
