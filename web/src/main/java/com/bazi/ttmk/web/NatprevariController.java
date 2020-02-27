package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Natprevar;
import com.bazi.ttmk.service.NatprevariService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/natprevari")
@CrossOrigin(origins = "http://localhost:3000")
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

    @PostMapping
    //@PreAuthorize("hasRole('ROLE_MANAGER')")
    public Natprevar createNatprevar(Integer idSezona,
                                     Integer idLiga,
                                     Integer kolo,
                                     Integer idSala,
                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dataOdigran,
                                     Integer idTimDomakjin,
                                     Integer idTimGostinid,
                                     Integer poeniDomakjin,
                                     Integer poeniGostin) {
        return this.natprevariService.createNatprevar(idSezona,idLiga, kolo, idSala, dataOdigran, idTimDomakjin, idTimGostinid, poeniDomakjin, poeniGostin);
    }

    

}
