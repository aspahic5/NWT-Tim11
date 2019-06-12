package com.example.demo.Repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Propolis;

@Repository
public interface PropolisRepository extends CrudRepository<Propolis,Integer> {

	@Query(value="SELECT propolis_propolis_id FROM kosnica_ids_propolis  WHERE kosnica_kosnica_id=:id", nativeQuery = true)
	public List<Integer> getIds(@Param("id")int id);

	@Query(value="SELECT * FROM propolis  WHERE date=:date", nativeQuery = true)
	public Iterable<Propolis> getPD(@Param("date")Date date);

	@Query(value="SELECT * FROM propolis  WHERE propolis_id = ANY(SELECT propolis_propolis_id FROM kosnica_ids_propolis  WHERE kosnica_kosnica_id=:id)", nativeQuery = true)
	public Iterable<Propolis> getIdSviK(@Param("id")int id);


	
}
