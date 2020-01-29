package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Sezona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SezoniRepository extends JpaRepository<Sezona, Integer> {
}
