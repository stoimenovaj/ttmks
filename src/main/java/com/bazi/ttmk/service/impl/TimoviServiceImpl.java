package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.Grad;
import com.bazi.ttmk.model.Tim;
import com.bazi.ttmk.repository.GradoviRepository;
import com.bazi.ttmk.repository.TimoviRepository;
import com.bazi.ttmk.service.TimoviService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimoviServiceImpl implements TimoviService {

    private final TimoviRepository timoviRepository;

    private final GradoviRepository gradoviRepository;

    public TimoviServiceImpl(TimoviRepository timoviRepository, GradoviRepository gradoviRepository) {
        this.timoviRepository = timoviRepository;
        this.gradoviRepository = gradoviRepository;
    }

    @Override
    public List<Tim> getAllTimovi() {
        return this.timoviRepository.findAll();
    }

    @Override
    public Tim createTim(Integer idGrad, String imeTim, Integer godinaOsnovan, String kontaktEmail, String kontaktLice, String kontaktTelefon) {
        Grad grad = this.gradoviRepository.findById(idGrad).orElseThrow(() -> new RuntimeException("Gradot with id " + idGrad + " not found"));
        Tim tim = new Tim();
        tim.setGrad(grad);
        tim.setImeTim(imeTim);
        tim.setGodinaOsnovan(godinaOsnovan);
        tim.setKontaktEmail(kontaktEmail);
        tim.setKontaktLice(kontaktLice);
        tim.setKontaktTelefon(kontaktTelefon);
        return this.timoviRepository.save(tim);
    }
}
