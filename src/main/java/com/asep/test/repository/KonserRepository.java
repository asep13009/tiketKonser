package com.asep.test.repository;

import com.asep.test.model.Konser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KonserRepository extends JpaRepository<Konser,String> {
    @Query(
            value = "SELECT * FROM konser  WHERE nama_konser like %?1% or desc_konser like %?1% or nama_konser like %?2% or desc_konser like %?2%  ",
            nativeQuery = true)
    List<Konser> search(String search, String search2);
}
