package com.example.demo.Repositories;

import com.example.demo.Entities.Aktivnost;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AktivnostRepositroy extends CrudRepository<Aktivnost, Integer> {

    @Query(value = "SELECT * FROM aktivnost WHERE aktivnost_id in (SELECT aktivnosti_aktivnost_id FROM kosnica_aktivnosti WHERE kosnica_kosnica_id = (SELECT kosnica_id FROM kosnica WHERE kosnica_id = :id))", nativeQuery = true)
	public Iterable<Aktivnost> dajAktinvostiOdKosnice(@Param("id") int id);

}