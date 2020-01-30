package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Set;
import com.bazi.ttmk.model.SetId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetoviRepository extends JpaRepository<Set, SetId> {

}
