package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Turnir;
import com.bazi.ttmk.model.TurnirId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface TurniriRepository extends JpaRepository<Turnir, TurnirId> {

    List<Turnir> findBySezona_IdSezonaOrderByDataNaOdrzhuvanje(int idSezona);

}
