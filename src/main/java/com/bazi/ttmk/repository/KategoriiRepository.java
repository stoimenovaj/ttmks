package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Kategorija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KategoriiRepository extends JpaRepository<Kategorija, Integer> {

}
