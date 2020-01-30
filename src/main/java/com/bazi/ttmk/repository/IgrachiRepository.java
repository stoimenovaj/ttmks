package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Igrachi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IgrachiRepository extends JpaRepository<Igrachi,Integer> {

}
