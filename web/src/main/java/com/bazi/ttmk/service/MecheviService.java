package com.bazi.ttmk.service;

import com.bazi.ttmk.model.Mech;
import com.bazi.ttmk.model.dto.IgrachiInTurnirMech;
import com.bazi.ttmk.model.dto.MechRequest;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface MecheviService {

    List<Mech> getAllMechevi();

    Mech createMechForNatprevar(Integer idDomakjin , Integer idGostin, Integer dobieniSetoviDomakjin, Integer dobieniSetoviGostin, Integer idSudija, Integer idNatprevar);

    Mech createMechForTurnir(Integer idTurnir, Integer idKategorija, Integer fazaRedenBroj,Integer idDomakjin , Integer idGostin, Integer dobieniSetoviDomakjin, Integer dobieniSetoviGostin, Integer idSudija);

    IgrachiInTurnirMech getProtivnik(Integer idTurnir, Integer idKategorija, Integer brojFaza, Integer idIgrach);

    Mech createMechForNatprevar(MechRequest request);

}
