package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Ligi;
import com.bazi.ttmk.model.LigiId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigiRepository extends JpaRepository<Ligi, LigiId> {

}
