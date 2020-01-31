package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Spagja;
import com.bazi.ttmk.model.SpagjaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SpagjaRepository extends JpaRepository<Spagja, SpagjaId> {

}
