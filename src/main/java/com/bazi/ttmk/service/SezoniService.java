package com.bazi.ttmk.service;

import com.bazi.ttmk.model.Liga;
import com.bazi.ttmk.model.Sezona;

import java.util.List;

public interface SezoniService {

    List<Sezona> getAllSezoni();

    List<Liga> getAllLigiInSezona(int idSezona);

}
