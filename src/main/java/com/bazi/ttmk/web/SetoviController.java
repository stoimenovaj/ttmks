package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Set;
import com.bazi.ttmk.service.SetoviService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/setovi")
public class SetoviController {
    private final SetoviService setoviService;

    public SetoviController(SetoviService setoviService) {
        this.setoviService = setoviService;
    }

    @GetMapping
    public List<Set> findAll() {
        return this.setoviService.getAllSetovi();
    }
}
