package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.demo.Entities.Unos;

@Repository
public interface UnosRepository extends CrudRepository<Unos,Integer> {

    @Query(value="SELECT * FROM unos  WHERE kosnica_id=:id", nativeQuery = true)
	public Iterable<Unos> getIdsK(@Param("id")int id);

}
