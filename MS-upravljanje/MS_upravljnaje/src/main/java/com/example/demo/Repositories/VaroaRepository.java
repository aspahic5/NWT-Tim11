package com.example.demo.Repositories;

import com.example.demo.Entities.Varoa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaroaRepository extends CrudRepository<Varoa, Integer> {

}