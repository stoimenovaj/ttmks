package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Kategorii;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KategoriiRepository extends JpaRepository<Kategorii,Integer> {

}
