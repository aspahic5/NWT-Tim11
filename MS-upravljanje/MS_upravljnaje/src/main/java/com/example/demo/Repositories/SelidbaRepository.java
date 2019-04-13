package com.example.demo.Repositories;

import com.example.demo.Entities.Selidba;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SelidbaRepository extends CrudRepository<Selidba, Integer> {
    
    @Query(value = "SELECT * FROM selidba WHERE selidba_id in (SELECT selidbe_selidba_id FROM kosnica_selidbe WHERE kosnica_kosnica_id = (SELECT kosnica_id FROM kosnica WHERE kosnica_id = :id))", nativeQuery = true)
    public Iterable<Selidba> dajSelidbeOdKosnice(@Param("id") int id);
}