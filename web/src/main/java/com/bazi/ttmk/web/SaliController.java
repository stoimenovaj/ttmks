package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Sala;
import com.bazi.ttmk.service.SaliService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/sali")
@CrossOrigin(origins = "http://localhost:3000")
public class SaliController {
    private final SaliService saliService;

    public SaliController(SaliService saliService) {
        this.saliService = saliService;
    }

    @GetMapping
    public List<Sala> getAllSali() {
        return this.saliService.getAllSali();
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public Sala createSala(String imeSala,
                           Integer idGrad) {
        return this.saliService.createSala(imeSala, idGrad);

    }

    @GetMapping("/{idGrad}")
    public List<Sala> getSaliFromGrad(@PathVariable int idGrad){
        return this.saliService.getSaliFromGrad(idGrad);
    }
}