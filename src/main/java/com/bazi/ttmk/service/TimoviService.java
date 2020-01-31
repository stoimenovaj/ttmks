package com.bazi.ttmk.service;

import com.bazi.ttmk.model.Tim;

import java.util.List;

public interface TimoviService {

    List<Tim> getAllTimovi();

    Tim createTim(Integer idGrad, String imeTim, Integer godinaOsnovan, String kontaktEmail, String kontaktLice, String kontaktTelefon);

}
