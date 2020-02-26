package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Faza;
import com.bazi.ttmk.model.FazaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FaziRepository extends JpaRepository<Faza, FazaId> {

    List<Faza> findByIdTurnirAndIdKategorija(int idTurnir, int idKategorija);

    Faza findByIdTurnirAndIdKategorijaAndBrojFaza(int idTurnir, int idKategorija, int brojFaza);

}
