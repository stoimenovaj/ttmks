package com.bazi.ttmk.service;

import com.bazi.ttmk.model.Igrach;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public interface IgrachiService {

    List<Igrach> getAllIgrachi();

    Igrach createIgrach(Integer idLice, String opisNaReket, Date posledenLekarskiPregled, Integer idKategorija, Integer idTim);

}
