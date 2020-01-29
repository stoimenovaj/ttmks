package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Sala;
import com.bazi.ttmk.repository.SaliRepository;
import com.bazi.ttmk.repository.SezoniRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/sezoni")
public class SezoniController {

    private final SezoniRepository sezoni;
    private final SaliRepository sali;

    public SezoniController(SezoniRepository sezoni, SaliRepository sali) {
        this.sezoni = sezoni;
        this.sali = sali;
    }

    @GetMapping
    public List<Sala> getSezoni(){
        return this.sali.findAll();
    }

}
