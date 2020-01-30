package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Igrachi;
import com.bazi.ttmk.repository.IgrachiRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/igrachi")
public class IgrachiController {
    private final IgrachiRepository igrachiRepository;

    public IgrachiController(IgrachiRepository igrachiRepository) {
        this.igrachiRepository = igrachiRepository;
    }

    @GetMapping
    public List<Igrachi> findAll(){ return this.igrachiRepository.findAll(); }
}
