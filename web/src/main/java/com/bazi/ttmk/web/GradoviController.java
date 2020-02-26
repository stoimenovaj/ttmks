package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Grad;
import com.bazi.ttmk.service.GradoviService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/gradovi")
@CrossOrigin(origins = "http://localhost:3000")
public class GradoviController {
    private final GradoviService gradoviService;

    public GradoviController(GradoviService gradoviService) {
        this.gradoviService = gradoviService;
    }

    @GetMapping
    public List<Grad> findAll() {
        return this.gradoviService.getAllGradovi();
    }

    @PostMapping
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public Grad createGrad(String imeGrad){
        return this.gradoviService.createGrad(imeGrad);
    }
}
