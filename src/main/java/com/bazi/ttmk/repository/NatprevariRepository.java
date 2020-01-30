package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Natprevar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NatprevariRepository extends JpaRepository<Natprevar, Integer> {

}
