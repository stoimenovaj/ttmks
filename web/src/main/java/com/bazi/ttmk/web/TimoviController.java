package com.bazi.ttmk.web;

import com.bazi.ttmk.model.Sala;
import com.bazi.ttmk.model.Tim;
import com.bazi.ttmk.model.dto.IgrachMechevi;
import com.bazi.ttmk.model.dto.TimDTO;
import com.bazi.ttmk.service.TimoviService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/timovi")
@CrossOrigin(origins = "http://localhost:3000")
public class TimoviController {
    private final TimoviService timoviService;

    public TimoviController(TimoviService timoviService) {
        this.timoviService = timoviService;
    }

    @GetMapping
    public List<Tim> findAll() {
        return this.timoviService.getAllTimovi();
    }

    @PostMapping
    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    public Tim creatTim(Integer idGrad,
                        String imeTim,
                        Integer godinaOsnovan,
                        String kontaktEmail,
                        String kontaktLice,
                        String kontaktTelefon) {
        return this.timoviService.createTim(idGrad, imeTim, godinaOsnovan, kontaktEmail, kontaktLice, kontaktTelefon);
    }

    @GetMapping(path = "/{idTim}/igrachi")
    List<Object> getIgrachMechevi(
            @PathVariable Integer idTim,
            @RequestParam Integer idSezona,
            @RequestParam Integer idLiga){
        return this.timoviService.findIgrachiMechevi(idTim, idSezona, idLiga);
    }

    @GetMapping(path = "/{idTim}/srekjna-sala")
    List<Object> getSrekjniSaliForTeam(@PathVariable Integer idTim){
        return this.timoviService.findSrekjniSali(idTim);
    }
    
    @GetMapping(path = "/dto")
    public List<TimDTO> getAllTimoviDTO(){
        return this.timoviService.getAllTimovi().stream().map(tim -> new TimDTO(tim.getIdTim(), tim.getImeTim()))
                .collect(Collectors.toList());

    @GetMapping(path = "/{idTim}/tim-natprevari-stats")
    List<Object> getTimNatprevariStats(@PathVariable Integer idTim){
        return this.timoviService.findStatsForTim(idTim);
    }

    @GetMapping(path = "/{idTim}/tim-domakjin")
    List<Object> pobediVoGradOsnovan(@PathVariable Integer idTim){
        return this.timoviService.findPobediVoGradOsnovan(idTim);
    }

    @GetMapping(path = "/{idIgrach}/najdobra-faza")
    List<Object> najdobraFazaZaIgrach(@PathVariable Integer idIgrach){
        return this.timoviService.findNajdobraFazaForIgrach(idIgrach);
    }

}
