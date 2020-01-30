package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Tim;
import com.bazi.ttmk.service.TimoviService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/timovi")
public class TimoviController {
    private final TimoviService timoviService;

    public TimoviController(TimoviService timoviService) {
        this.timoviService = timoviService;
    }

    @GetMapping
    public List<Tim> findAll() {
        return this.timoviService.getAllTimovi();
    }
}
