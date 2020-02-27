package com.bazi.ttmk.service;

import com.bazi.ttmk.model.Liga;
import com.bazi.ttmk.model.Natprevar;
import com.bazi.ttmk.model.dto.NatprevarInLiga;
import com.bazi.ttmk.model.dto.TimDTO;
import com.bazi.ttmk.model.dto.TopListTeamStats;

import java.util.List;
import java.util.Map;

public interface LigiService {

    List<Liga> getAllLigi();

    Liga createLiga(int idSezona, String imeLiga);

    List<TopListTeamStats> topLista(int idSezona, int idLiga);

    List<NatprevarInLiga> getAllNatprevariVoLiga(int idSezona, int idLiga);

    List<TimDTO> getAllTimoviILiga(int idSezona, int idLiga);

}
