package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Setovi;
import com.bazi.ttmk.model.SetoviId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetoviRepository extends JpaRepository<Setovi, SetoviId> {

}
