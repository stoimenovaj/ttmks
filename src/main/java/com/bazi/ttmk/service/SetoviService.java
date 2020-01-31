package com.bazi.ttmk.service;

import com.bazi.ttmk.model.Set;

import java.util.List;

public interface SetoviService {

    List<Set> getAllSetovi();

    Set createSet(Integer idMech,Integer poeniDomakjin, Integer poeniGostin);

}
