package com.bazi.ttmk.service;

import com.bazi.ttmk.model.Sala;
import com.bazi.ttmk.model.Tim;
import com.bazi.ttmk.model.dto.IgrachDTO;

import java.util.List;

public interface TimoviService {

    List<Tim> getAllTimovi();

    Tim createTim(Integer idGrad, String imeTim, Integer godinaOsnovan, String kontaktEmail, String kontaktLice, String kontaktTelefon);

    List<Object> findIgrachiMechevi(Integer idTim, Integer idSezona, Integer idLiga);

    List<Object> findSrekjniSali(Integer idTim);

    List<Object> findStatsForTim(Integer idTim);

    List<IgrachDTO> findIgrachiFromTim(int idTim);
}
