package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Natprevar;
import com.bazi.ttmk.service.NatprevariService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/natprevari")
public class NatprevariController {
    private final NatprevariService natprevariService;

    public NatprevariController(NatprevariService natprevariService) {
        this.natprevariService = natprevariService;
    }

    @GetMapping
    public List<Natprevar> findAll() {
        return this.natprevariService.getAllNatprevari();
    }

    @GetMapping(path = "/broj")
    public int broj(int idSezona, int idLiga, int timId) {
        return this.natprevariService.brojDobieni(idSezona, idLiga, timId);
    }
}
