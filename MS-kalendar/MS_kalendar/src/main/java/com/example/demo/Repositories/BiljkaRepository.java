package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Biljka;


@Repository
public interface BiljkaRepository extends CrudRepository<Biljka,Integer> {
	@Query(value="SELECT biljka_biljka_id FROM biljka_lokacije WHERE lokacije_lokacija_id=:id", nativeQuery = true)
	public List<Integer> getIds(@Param("id")int id);
	
	@Query(value="SELECT * FROM biljka WHERE biljka_id=:id", nativeQuery = true)
	public Biljka getBiljka(@Param("id")int id);
}
