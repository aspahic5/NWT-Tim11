package com.example.demo.Repositories;

import com.example.demo.Entities.Selidba;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SelidbaRepository extends CrudRepository<Selidba, Integer> {
    
    @Query(value = "SELECT * FROM selidba WHERE selidba_id in (SELECT selidbe_selidba_id FROM kosnica_selidbe WHERE kosnica_kosnica_id = (SELECT kosnica_id FROM kosnica WHERE kosnica_id = :id))", nativeQuery = true)
    public Iterable<Selidba> dajSelidbeOdKosnice(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE Selidba s SET s.dobit = s.dobit + :dobit WHERE s.selidba_id = :id", nativeQuery = true)
    public void azurirajDobitOdSelidbe(@Param("dobit") double dobit, @Param("id") int id);
}