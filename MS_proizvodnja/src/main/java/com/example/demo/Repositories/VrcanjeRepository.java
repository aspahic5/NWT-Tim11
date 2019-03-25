package com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Vrcanje;

@Repository
public interface VrcanjeRepository extends CrudRepository<Vrcanje,Integer> {

}
