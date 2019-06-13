package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Maticna_mlijec;

@Repository
public interface MaticnaMlijecRepository extends CrudRepository<Maticna_mlijec,Integer> {
	
	@Query(value="SELECT SUM(kolicina*km_kg) WHERE kosnica_kosnice_id=?", nativeQuery = true)
	public String obracunMaticnaMlijecKosnica(int id); 

	@Query(value="SELECT * FROM maticna_mlijec  WHERE maticna_mlijec_id = ANY(SELECT maticna_maticna_mlijec_id FROM kosnica_ids_maticna WHERE kosnica_kosnica_id=:id)", nativeQuery = true)
	public Iterable<Maticna_mlijec> getIdSviK(@Param("id")int id);

}
