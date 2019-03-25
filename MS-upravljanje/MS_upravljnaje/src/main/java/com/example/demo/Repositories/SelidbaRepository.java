package com.example.demo.Repositories;

import com.example.demo.Entities.Selidba;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelidbaRepository extends CrudRepository<Selidba, Integer> {

}