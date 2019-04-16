package com.example.demo.Repositories;

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
	
}
