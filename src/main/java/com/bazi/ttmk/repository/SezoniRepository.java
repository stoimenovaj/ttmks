package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Sezoni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SezoniRepository extends JpaRepository<Sezoni, Integer> {
}
