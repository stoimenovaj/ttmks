package com.bazi.ttmk.service;

import com.bazi.ttmk.model.Mech;

import java.util.List;

public interface MecheviService {

    List<Mech> getAllMechevi();

    Mech createMechForNatprevar(Integer idDomakjin , Integer idGostin, Integer dobieniSetoviDomakjin, Integer dobieniSetoviGostin, Integer idSudija, Integer idNatprevar);

    Mech createMechForTurnir(Integer idTurnir, Integer idKategorija, Integer fazaRedenBroj,Integer idDomakjin , Integer idGostin, Integer dobieniSetoviDomakjin, Integer dobieniSetoviGostin, Integer idSudija);

}
