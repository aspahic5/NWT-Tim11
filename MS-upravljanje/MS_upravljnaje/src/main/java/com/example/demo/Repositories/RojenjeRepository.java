package com.example.demo.Repositories;

import com.example.demo.Entities.Rojenje;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RojenjeRepository extends CrudRepository<Rojenje,Integer> {

}