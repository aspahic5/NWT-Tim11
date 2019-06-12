package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Vrcanje;

@Repository
public interface VrcanjeRepository extends CrudRepository<Vrcanje,Integer> {

    @Query(value="SELECT * FROM vrcanje  WHERE vrcanje_id = ANY(SELECT vrcanje_vrcanje_id FROM kosnica_ids_vrcanje  WHERE kosnica_kosnica_id=:id)", nativeQuery = true)
	public Iterable<Vrcanje> getIdSviK(@Param("id")int id);

}
