package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.*;
import com.bazi.ttmk.model.dto.NatprevarRequest;
import com.bazi.ttmk.repository.LigiRepository;
import com.bazi.ttmk.repository.NatprevariRepository;
import com.bazi.ttmk.repository.SaliRepository;
import com.bazi.ttmk.repository.TimoviRepository;
import com.bazi.ttmk.service.NatprevariService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NatprevariServiceImpl implements NatprevariService {

    private final NatprevariRepository natprevariRepository;

    private final LigiRepository ligiRepository;

    private final SaliRepository saliRepository;

    private final TimoviRepository timoviRepository;

    public NatprevariServiceImpl(NatprevariRepository natprevariRepository, LigiRepository ligiRepository, SaliRepository saliRepository, TimoviRepository timoviRepository) {
        this.natprevariRepository = natprevariRepository;
        this.ligiRepository = ligiRepository;
        this.saliRepository = saliRepository;
        this.timoviRepository = timoviRepository;
    }

    @Override
    public List<Natprevar> getAllNatprevari() {
        return this.natprevariRepository.findAll();
    }

    @Override
    public int brojDobieni(int sezonaId, int ligaId, int timId) {
        return natprevariRepository.brojDomakjinOsvoeniMechevi(sezonaId, ligaId, timId).orElse(0);
    }

    @Override
    public Natprevar createNatprevar(Integer idSezona, Integer idLiga, Integer kolo, Integer idSala, Date dataOdigran, Integer idTimDomakjin, Integer idTimGostinid, Integer poeniDomakjin, Integer poeniGostin) {
        Natprevar natprevar = new Natprevar();
        fillNatprevarWithForeignEntities(idLiga, idSezona, idSala, idTimDomakjin, idTimGostinid, natprevar);
        natprevar.setKolo(kolo);
        natprevar.setDataOdigran(dataOdigran);
        natprevar.setDobieniMecheviDomakjin(poeniDomakjin);
        natprevar.setDobieniMecheviGostin(poeniGostin);
        return this.natprevariRepository.save(natprevar);
    }

    private void fillNatprevarWithForeignEntities(int idLiga, int idSezona, int idSala, int idTimDomakjin, int idTimGostinid, Natprevar toFill){
        Liga liga = this.ligiRepository.findById(new LigaId(idLiga, idSezona)).orElseThrow(() -> new RuntimeException("Liga with id (" + idSezona + "," + idLiga + ") not found"));
        Sala sala = this.saliRepository.findById(idSala).orElseThrow(() -> new RuntimeException("Sala with id (" + idSala + ") not found"));
        Tim tim1 = this.timoviRepository.findById(idTimDomakjin).orElseThrow(() -> new RuntimeException("Tim with id (" + idTimDomakjin + ") not found"));
        Tim tim2 = this.timoviRepository.findById(idTimGostinid).orElseThrow(() -> new RuntimeException("Tim with id (" + idTimDomakjin + ") not found"));
        toFill.setLiga(liga);
        toFill.setSalaOdrzuvanje(sala);
        toFill.setTimDomakjin(tim1);
        toFill.setTimGostin(tim2);
    }

    @Override
    public Natprevar createNatprevar(NatprevarRequest request) {
        Natprevar natprevar = new Natprevar();
        fillNatprevarWithForeignEntities(request.getIdLiga(), request.getIdSezona(), request.getIdSalaOdrzuvanje(),
                request.getIdTimDomakjin(), request.getIdTimGostin(), natprevar);
        natprevar.setKolo(request.getKolo());
        natprevar.setDataOdigran(request.getDataOdigran());
        return this.natprevariRepository.saveAndFlush(natprevar);
    }
}
