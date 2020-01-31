package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Grad;
import com.bazi.ttmk.service.GradoviService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/gradovi")
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
    public Grad createGrad(String imeGrad){
        return this.gradoviService.createGrad(imeGrad);
    }
}
