package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Sudija;
import com.bazi.ttmk.repository.SudiiRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/sudii")
public class SudiiController {
    private final SudiiRepository sudiiRepository;

    public SudiiController(SudiiRepository sudiiRepository) {
        this.sudiiRepository = sudiiRepository;
    }

    @GetMapping
    public List<Sudija> findAll() { return this.sudiiRepository.findAll(); }
}
