package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Fazi;
import com.bazi.ttmk.model.FaziId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaziRepository extends JpaRepository<Fazi, FaziId> {
}
