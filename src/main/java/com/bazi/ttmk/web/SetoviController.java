package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Setovi;
import com.bazi.ttmk.repository.SetoviRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/setovi")
public class SetoviController {
    private final SetoviRepository setoviRepository;

    public SetoviController(SetoviRepository setoviRepository) {
        this.setoviRepository = setoviRepository;
    }

    @GetMapping
    public List<Setovi> findAll() { return this.setoviRepository.findAll(); }
}
