package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Sezona;
import com.bazi.ttmk.service.SezoniService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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

    @PostMapping
    public Sezona createSezona(String godina
            , String pretsedatel){
        return this.sezoniService.createSezona(godina,pretsedatel);
    }

}
