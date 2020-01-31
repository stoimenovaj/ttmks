package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Faza;
import com.bazi.ttmk.service.FaziService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/fazi")
public class FaziController {
    private final FaziService faziService;

    public FaziController(FaziService faziService) {
        this.faziService = faziService;
    }

    @GetMapping
    public List<Faza> getAllFazi() {
        return this.faziService.getAllFazi();
    }

    @PostMapping
    public Faza createFaza(int idTurnir,
                           int idKategorija,
                           String opisFaza,
                           int brojFaza){
        return this.faziService.createFaza(idTurnir,idKategorija,opisFaza,brojFaza);
    }
}
