package com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Maticna_mlijec;

@Repository
public interface MaticnaMlijecRepository extends CrudRepository<Maticna_mlijec,Integer> {

}
