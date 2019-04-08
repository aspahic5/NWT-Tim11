package com.example.demo.Repositories;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Korisnik;



@Repository
public interface KorisnikRepository extends CrudRepository<Korisnik,Integer> {
	@Query(value="SELECT * FROM korisnici WHERE username=:username and password=:password", nativeQuery = true)
	public Korisnik provjeriKorisnik(@Param("username")String username,@Param("password")String password);

}
