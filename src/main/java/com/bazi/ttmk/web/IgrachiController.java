package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Igrach;
import com.bazi.ttmk.service.IgrachiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/igrachi")
public class IgrachiController {
    private final IgrachiService igrachiService;

    public IgrachiController(IgrachiService igrachiService) {
        this.igrachiService = igrachiService;
    }

    @GetMapping
    public List<Igrach> findAll() {
        return this.igrachiService.getAllIgrachi();
    }
}
