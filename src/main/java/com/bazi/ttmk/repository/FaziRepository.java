package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Faza;
import com.bazi.ttmk.model.FazaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaziRepository extends JpaRepository<Faza, FazaId> {

    List<Faza> findById_IdTurnirAndId_IdKategorija(int idTurnir, int idKategorija);

}
