package com.bazi.ttmk.service;

import com.bazi.ttmk.model.Spagja;

import java.util.List;

public interface SpagjaService {

    List<Spagja> getAllSpagja();

    Spagja createSpagja(Integer idSezona, Integer idLiga, Integer idTim, Integer timPoeni);

}
