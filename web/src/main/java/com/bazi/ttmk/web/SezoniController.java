package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Liga;
import com.bazi.ttmk.model.Sezona;
import com.bazi.ttmk.model.Turnir;
import com.bazi.ttmk.model.dto.LigiWithTimovi;
import com.bazi.ttmk.service.SezoniService;
import com.bazi.ttmk.service.TurniriService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/sezoni")
@CrossOrigin(origins = "http://localhost:3000")
public class SezoniController {

    private final SezoniService sezoniService;
    private final TurniriService turniriService;

    public SezoniController(SezoniService sezoniService, TurniriService turniriService) {
        this.sezoniService = sezoniService;
        this.turniriService = turniriService;
    }

    @GetMapping
    public List<Sezona> getSezoni() {
        return this.sezoniService.getAllSezoni();
    }

    @PostMapping
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public Sezona createSezona(String godina
            , String pretsedatel) {
        return this.sezoniService.createSezona(godina, pretsedatel);
    }

    @GetMapping(path = "/{idSezona}/ligi")
    public List<Liga> findAllLigiInSezona(@PathVariable int idSezona){
        return this.sezoniService.getAllLigiInSezona(idSezona);
    }

    @GetMapping(path = "/{idSezona}/turniri")
    public List<Turnir> findAllTurniriInSezona(@PathVariable int idSezona){
        return this.sezoniService.getAllTurniriInSezona(idSezona);
    }

    @GetMapping(path = "/{idSezona}/ligiWithTimovi")
    public List<LigiWithTimovi> findAllLigiWithTimovi(@PathVariable int idSezona){
        return this.turniriService.findLigiWithTimovi(idSezona);
    }
}
