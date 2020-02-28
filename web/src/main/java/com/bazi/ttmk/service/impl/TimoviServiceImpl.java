package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.Grad;
import com.bazi.ttmk.model.Sala;
import com.bazi.ttmk.model.Tim;
import com.bazi.ttmk.repository.GradoviRepository;
import com.bazi.ttmk.repository.TimoviRepository;
import com.bazi.ttmk.service.TimoviService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    @Override
    public List<Object> findIgrachiMechevi(Integer idTim, Integer idSezona, Integer idLiga) {
        return this.timoviRepository.findCrazyQuery(idTim, idSezona, idLiga);
    }

    @Override
    public List<Object> findSrekjniSali(Integer idTim) {
        return this.timoviRepository.findSrekjniSali(idTim);
    }

    @Override
    public List<Object> findStatsForTim(Integer idTim) {
        return this.timoviRepository.findTimStats(idTim);
    }

    @Override
    public List<Object> findPobediVoGradOsnovan(Integer idTim) {
        return this.timoviRepository.pobediVoGradOsnovan(idTim);
    }

    @Override
    public List<Object> findNajdobraFazaForIgrach(Integer idIgrach) {
        return this.timoviRepository.findNajdobraFazaForIgrach(idIgrach);
    }
}
