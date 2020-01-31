package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Liga;
import com.bazi.ttmk.model.Sezona;
import com.bazi.ttmk.service.SezoniService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/sezoni")
public class SezoniController {

    private final SezoniService sezoniService;

    public SezoniController(SezoniService sezoniService) {
        this.sezoniService = sezoniService;
    }

    @GetMapping
    public List<Sezona> getSezoni() {
        return this.sezoniService.getAllSezoni();
    }

    @GetMapping(path = "/{idSezona}/ligi")
    public List<Liga> findAllLigiInSezona(@PathVariable int idSezona){
        return this.sezoniService.getAllLigiInSezona(idSezona);
    }

}
