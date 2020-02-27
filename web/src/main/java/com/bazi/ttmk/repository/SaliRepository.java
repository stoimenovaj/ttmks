package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SaliRepository extends JpaRepository<Sala, Integer> {

    List<Sala> findAllByGrad_IdGrad(int idGrad);

}
