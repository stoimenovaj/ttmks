package com.bazi.ttmk.service;

import com.bazi.ttmk.model.Sezona;

import java.util.List;

public interface SezoniService {

    List<Sezona> getAllSezoni();

    Sezona createSezona(String godina, String pretsedatel);

}
