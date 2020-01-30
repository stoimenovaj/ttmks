package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Tim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimoviRepository extends JpaRepository<Tim,Integer> {

}
