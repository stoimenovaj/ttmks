package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Liga;
import com.bazi.ttmk.model.Sezona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SezoniRepository extends JpaRepository<Sezona, Integer> {
}
