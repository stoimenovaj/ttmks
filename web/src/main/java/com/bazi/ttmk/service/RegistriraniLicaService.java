package com.bazi.ttmk.service;

import com.bazi.ttmk.model.RegistriranoLice;

import java.util.List;

public interface RegistriraniLicaService {

    List<RegistriranoLice> getAllRegistriraniLica();

    RegistriranoLice createRegistriranoLice(String imeLice, String prezimeLice, int godiniLice, Integer idGrad);

}
