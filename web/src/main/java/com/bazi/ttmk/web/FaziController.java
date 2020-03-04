package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Faza;
import com.bazi.ttmk.model.dto.FazaInTurnir;
import com.bazi.ttmk.service.FaziService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/fazi")
@CrossOrigin(origins = "http://localhost:3000")
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
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public Faza createFaza(int idTurnir,
                           int idKategorija,
                           String opisFaza,
                           int brojFaza){
        return this.faziService.createFaza(idTurnir,idKategorija,opisFaza,brojFaza);
    }

}
