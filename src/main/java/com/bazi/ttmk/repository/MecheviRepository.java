package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Mech;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MecheviRepository extends JpaRepository<Mech, Integer> {

    // site natreavri kade tim e domakjin where domakin osvoeni mechevi >

}
