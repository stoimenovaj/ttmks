package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Mech;
import com.bazi.ttmk.service.MecheviService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/mechevi")
public class MecheviController {
    private final MecheviService mecheviService;

    public MecheviController(MecheviService mecheviService) {
        this.mecheviService = mecheviService;
    }

    @GetMapping
    public List<Mech> findAll() {
        return this.mecheviService.getAllMechevi();
    }

    @PostMapping(path="/natprevar")
    //@PreAuthorize("hasRole('ROLE_MANAGER')")
    public Mech createNatprevarMech(Integer idDomakjin ,
                           Integer idGostin,
                           Integer dobieniSetoviDomakjin,
                           Integer dobieniSetoviGostin,
                           Integer idSudija,
                           Integer idNatprevar){
        return this.mecheviService.createMechForNatprevar(idDomakjin,idGostin,dobieniSetoviDomakjin,dobieniSetoviGostin,idSudija,idNatprevar);
    }

    @PostMapping(path="/turnir")
    //@PreAuthorize("hasRole('ROLE_MANAGER')")
    public Mech createMechForTurnir(Integer idTurnir,
                                    Integer idKategorija,
                                    Integer fazaRedenBroj,
                                    Integer idDomakjin ,
                                    Integer idGostin,
                                    Integer dobieniSetoviDomakjin,
                                    Integer dobieniSetoviGostin,
                                    Integer idSudija){
        return this.mecheviService.createMechForTurnir(idTurnir,idKategorija,fazaRedenBroj,idDomakjin,idGostin,dobieniSetoviDomakjin,dobieniSetoviGostin,idSudija);
    }

}
