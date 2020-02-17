package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Spagja;
import com.bazi.ttmk.model.SpagjaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SpagjaRepository extends JpaRepository<Spagja, SpagjaId> {

    List<Spagja> findByIdSezonaAndIdLigaOrderByTimPoeniDesc(int idSezona, int idLiga);

}
