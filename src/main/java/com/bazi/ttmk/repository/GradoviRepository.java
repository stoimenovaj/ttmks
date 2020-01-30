package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Grad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradoviRepository extends JpaRepository<Grad, Integer> {

}
