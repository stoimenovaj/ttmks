package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Mechevi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MecheviRepository extends JpaRepository<Mechevi,Integer> {

}
