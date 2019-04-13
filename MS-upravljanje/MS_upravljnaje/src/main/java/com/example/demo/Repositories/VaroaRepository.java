package com.example.demo.Repositories;

import com.example.demo.Entities.Varoa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VaroaRepository extends CrudRepository<Varoa, Integer> {


    @Query(value = "SELECT * FROM varoa v WHERE v.kosnica_id = :id", nativeQuery = true)
    public Iterable<Varoa> dajVarouOdKosnice(@Param("id") int id);
}