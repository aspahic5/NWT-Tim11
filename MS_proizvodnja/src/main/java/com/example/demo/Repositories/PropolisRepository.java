package com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Propolis;

@Repository
public interface PropolisRepository extends CrudRepository<Propolis,Integer> {

}
