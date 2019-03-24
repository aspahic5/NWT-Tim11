package com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Korisnik;



@Repository
public interface KorisnikRepository extends CrudRepository<Korisnik,Integer> {

}
