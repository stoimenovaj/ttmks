package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Liga;
import com.bazi.ttmk.model.Natprevar;
import com.bazi.ttmk.model.dto.NatprevarInLiga;
import com.bazi.ttmk.model.dto.TopListTeamStats;
import com.bazi.ttmk.service.LigiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/ligi")
public class LigiController {

    private final LigiService ligiService;

    public LigiController(LigiService ligiService) {
        this.ligiService = ligiService;
    }

    @GetMapping
    public List<Liga> findAll() {
        return this.ligiService.getAllLigi();
    }

    @GetMapping(path = "/top-lista")
    public List<TopListTeamStats> topLista(int idSezona, int idLiga){
        return this.ligiService.topLista(idSezona, idLiga);
    }

    @GetMapping(path = "/{idLiga}/natprevari")
    public List<NatprevarInLiga> getAllNatprevariVoLiga(int idSezona, @PathVariable int idLiga){
        return this.ligiService.getAllNatprevariVoLiga(idSezona, idLiga);
    }

}
