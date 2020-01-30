package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Tim;
import com.bazi.ttmk.repository.TimoviRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/timovi")
public class TimoviController {
    private final TimoviRepository timoviRepository;

    public TimoviController(TimoviRepository timoviRepository) {
        this.timoviRepository = timoviRepository;
    }

    @GetMapping
    public List<Tim> findAll() { return this.timoviRepository.findAll(); }
}
