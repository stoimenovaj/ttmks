package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Igrach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IgrachiRepository extends JpaRepository<Igrach, Integer> {

}
