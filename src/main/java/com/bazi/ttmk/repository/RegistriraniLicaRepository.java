package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.RegistriranoLice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistriraniLicaRepository extends JpaRepository<RegistriranoLice,Integer> {

}
