package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Turnir;
import com.bazi.ttmk.model.TurnirId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurniriRepository extends JpaRepository<Turnir,TurnirId> {

}
