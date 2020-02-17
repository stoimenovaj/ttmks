package com.bazi.ttmk.service;

import com.bazi.ttmk.model.Liga;
import com.bazi.ttmk.model.Sezona;
import com.bazi.ttmk.model.Turnir;

import java.util.List;

public interface SezoniService {

    List<Sezona> getAllSezoni();

    Sezona createSezona(String godina, String pretsedatel);

    List<Liga> getAllLigiInSezona(int idSezona);

    List<Turnir> getAllTurniriInSezona(int idSezona);

}
