package com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Kosnica;

@Repository
public interface KosnicaRepository extends CrudRepository<Kosnica,Integer> {

}
