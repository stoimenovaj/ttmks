package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Turnir;
import com.bazi.ttmk.repository.TurniriRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/turniri")
public class TurniriController {
    private final TurniriRepository turniriRepository;

    public TurniriController(TurniriRepository turniriRepository) {
        this.turniriRepository = turniriRepository;
    }

    @GetMapping
    public List<Turnir> findAll() { return this.turniriRepository.findAll(); }
}
