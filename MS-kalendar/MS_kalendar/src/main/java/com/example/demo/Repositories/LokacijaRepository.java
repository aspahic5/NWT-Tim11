package com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Lokacija;

@Repository
public interface LokacijaRepository extends CrudRepository<Lokacija,Integer>{

}
