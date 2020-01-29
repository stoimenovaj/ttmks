package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Fazi;
import com.bazi.ttmk.repository.FaziRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/fazi")
public class FaziController {
    private final FaziRepository faziRepository;

    public FaziController(FaziRepository faziRepository) {
        this.faziRepository = faziRepository;
    }

    @GetMapping
    public List<Fazi> findAll(){
        return this.faziRepository.findAll();
    }
}
