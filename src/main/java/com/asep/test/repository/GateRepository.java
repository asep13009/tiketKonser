package com.asep.test.repository;

import com.asep.test.model.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface  GateRepository extends JpaRepository<Gate,Long> {
}
