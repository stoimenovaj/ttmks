package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Turnir;
import com.bazi.ttmk.service.TurniriService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path="/turniri")
public class TurniriController {
    private final TurniriService turniriService;

    public TurniriController(TurniriService turniriService) {
        this.turniriService = turniriService;
    }

    @GetMapping
    public List<Turnir> findAll() {
        return this.turniriService.getAllTurniri();
    }


    @PostMapping
    //@PreAuthorize("hasRole('ROLE_MANAGER')")
    public Turnir createTurnir(int idSezona,
                               int idKategorija,
                               String ime,
                               @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date data,
                               int participacija,
                               int idSala,
                               int brIgrachi){
        return this.turniriService.createTurnir(idSezona, idKategorija, ime, data, participacija, idSala, brIgrachi);
    }

}
