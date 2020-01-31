package com.bazi.ttmk.service.impl;

import com.bazi.ttmk.model.Faza;
import com.bazi.ttmk.model.TurnirId;
import com.bazi.ttmk.repository.FaziRepository;
import com.bazi.ttmk.repository.TurniriRepository;
import com.bazi.ttmk.service.FaziService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaziServiceImpl implements FaziService {

    private final FaziRepository faziRepository;

    private final TurniriRepository turniriRepository;

    public FaziServiceImpl(FaziRepository faziRepository, TurniriRepository turniriRepository) {
        this.faziRepository = faziRepository;
        this.turniriRepository = turniriRepository;
    }

    @Override
    public List<Faza> getAllFazi() {
        return this.faziRepository.findAll();
    }

    @Override
    public Faza createFaza(int idTurnir, int idKategorija, String opisFaza, int brojFaza) {
        Faza faza = new Faza();
        faza.setIdTurnir(idTurnir);
        faza.setIdKategorija(idKategorija);
        faza.setOpisFaza(opisFaza);
        faza.setBrojFaza(brojFaza);
        faza.setTurnir(this.turniriRepository.findById(new TurnirId(idTurnir,idKategorija)).orElseThrow(()->new RuntimeException("Turnir with primary key (" + idTurnir +", " + idKategorija  + ") not found")));
        return this.faziRepository.save(faza);
    }
}
