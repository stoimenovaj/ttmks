package com.bazi.ttmk.service;

import com.bazi.ttmk.model.Natprevar;

import java.util.List;

public interface NatprevariService {

    List<Natprevar> getAllNatprevari();

    int brojDobieni(int sezonaId, int ligaId, int timId);

}
