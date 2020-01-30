package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Liga;
import com.bazi.ttmk.model.LigaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigiRepository extends JpaRepository<Liga, LigaId> {

}
