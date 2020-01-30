package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Sudija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SudiiRepository extends JpaRepository<Sudija,Integer> {

}
