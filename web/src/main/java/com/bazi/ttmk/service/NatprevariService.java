package com.bazi.ttmk.service;

import com.bazi.ttmk.model.Natprevar;
import com.bazi.ttmk.model.dto.NatprevarRequest;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public interface NatprevariService {

    List<Natprevar> getAllNatprevari();

    int brojDobieni(int sezonaId, int ligaId, int timId);

    Natprevar createNatprevar(Integer idSezona, Integer idLiga, Integer kolo, Integer idSala, Date dataOdigran, Integer idTimDomakjin, Integer idTimGostinid, Integer poeniDomakjin, Integer poeniGostin);

    Natprevar createNatprevar(NatprevarRequest request);

}
