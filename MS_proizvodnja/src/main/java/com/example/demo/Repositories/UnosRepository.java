package com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Unos;

@Repository
public interface UnosRepository extends CrudRepository<Unos,Integer> {

}
