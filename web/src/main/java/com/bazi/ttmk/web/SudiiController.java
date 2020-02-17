package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Sudija;
import com.bazi.ttmk.service.SudiiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/sudii")
public class SudiiController {
    private final SudiiService sudiiService;

    public SudiiController(SudiiService sudiiService) {
        this.sudiiService = sudiiService;
    }

    @GetMapping
    public List<Sudija> findAll() {
        return this.sudiiService.getAllSudii();
    }

    @PostMapping
    public Sudija createSudija(Integer idLice,
                               String titula) {
        return this.sudiiService.createSudija(idLice, titula);
    }

}
