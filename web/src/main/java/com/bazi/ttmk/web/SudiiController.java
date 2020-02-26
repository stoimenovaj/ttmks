package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Sudija;
import com.bazi.ttmk.service.SudiiService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/sudii")
@CrossOrigin(origins = "http://localhost:3000")
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
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public Sudija createSudija(Integer idLice,
                               String titula) {
        return this.sudiiService.createSudija(idLice, titula);
    }

}
