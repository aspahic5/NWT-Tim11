package com.example.demo.Repositories;

import com.example.demo.Entities.Kosnica;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KosnicaRepository extends CrudRepository<Kosnica,Integer> {
	
	@Query(value="SELECT * FROM kosnica WHERE vlasnik_id = :id", nativeQuery = true)
	public Iterable<Kosnica> dajKosniceOdVlasnika(@Param("id") int idk);

	@Query(value="SELECT * FROM kosnica", nativeQuery = true)
	public Iterable<Kosnica> dajKosniceOdSelidbeZaVlasnika(@Param("id") int ids, @Param("vlasnik") int vlasnik);


}