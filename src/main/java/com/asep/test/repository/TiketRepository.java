package com.asep.test.repository;

import com.asep.test.model.Tiket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TiketRepository extends JpaRepository<Tiket, String> {

}
