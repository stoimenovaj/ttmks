package com.bazi.ttmk.service;

import com.bazi.ttmk.model.Turnir;
import com.bazi.ttmk.model.dto.IgrachiInTurnirMech;
import com.bazi.ttmk.model.dto.LigiWithTimovi;
import com.bazi.ttmk.model.dto.FazaInTurnir;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TurniriService {

    List<Turnir> getAllTurniri();

    Turnir createTurnir(int idSezona, int idKategorija, String ime, Date data, int participacija, int idSala, int brIgrachi);

    Optional<Turnir> findTurnir(Integer idTurnir, Integer idKategorija);

    public IgrachiInTurnirMech getFinale(int idTurnir, int idKategorija);

    public List<LigiWithTimovi> findLigiWithTimovi(int idSezona);

    List<FazaInTurnir> getFaziForTurnir(int idTurnir, int idKategorija);

}
