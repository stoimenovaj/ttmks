package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Turnir;
import com.bazi.ttmk.service.TurniriService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/turniri")
public class TurniriController {
    private final TurniriService turniriService;

    public TurniriController(TurniriService turniriService) {
        this.turniriService = turniriService;
    }

    @GetMapping
    public List<Turnir> findAll() {
        return this.turniriService.getAllTurniri();
    }
}
