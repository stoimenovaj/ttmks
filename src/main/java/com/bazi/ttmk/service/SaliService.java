package com.bazi.ttmk.service;

import com.bazi.ttmk.model.Sala;

import java.util.List;

public interface SaliService {

    List<Sala> getAllSali();

    Sala createSala(String imeSala, Integer idGrad);

}
