package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Igrach;
import com.bazi.ttmk.service.IgrachiService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path="/igrachi")
@CrossOrigin(origins = "http://localhost:3000")
public class IgrachiController {
    private final IgrachiService igrachiService;

    public IgrachiController(IgrachiService igrachiService) {
        this.igrachiService = igrachiService;
    }

    @GetMapping
    public List<Igrach> findAll() {
        return this.igrachiService.getAllIgrachi();
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Igrach createIgrach(Integer idLice,
                               String opisNaReket,
                               @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date posledenLekarskiPregled,
                               Integer idKategorija,
                               Integer idTim){
        return this.igrachiService.createIgrach(idLice,opisNaReket,posledenLekarskiPregled,idKategorija,idTim);
    }

}
