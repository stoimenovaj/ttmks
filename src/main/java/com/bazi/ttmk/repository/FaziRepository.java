package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Faza;
import com.bazi.ttmk.model.FazaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaziRepository extends JpaRepository<Faza, FazaId> {
}
