package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaliRepository extends JpaRepository<Sala, Integer> {
}
