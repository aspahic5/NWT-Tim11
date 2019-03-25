package com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Rashodi;

@Repository
public interface RashodiRepository extends CrudRepository<Rashodi,Integer> {

}
