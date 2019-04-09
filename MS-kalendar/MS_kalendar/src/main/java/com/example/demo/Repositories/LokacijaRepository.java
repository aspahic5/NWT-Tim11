package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Lokacija;

@Repository
public interface LokacijaRepository extends CrudRepository<Lokacija,Integer>{
	@Query(value="SELECT lokacija_id FROM lokacija WHERE lokacija=:lokacija", nativeQuery = true)
	public int getIdlokacije(@Param("lokacija")String lokacija);

}
