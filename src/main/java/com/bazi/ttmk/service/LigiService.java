package com.bazi.ttmk.service;

import com.bazi.ttmk.model.Liga;

import java.util.List;

public interface LigiService {

    List<Liga> getAllLigi();

    Liga createLiga(int idSezona, String imeLiga);

}
