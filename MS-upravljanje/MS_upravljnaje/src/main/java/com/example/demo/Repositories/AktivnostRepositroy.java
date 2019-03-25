package com.example.demo.Repositories;

import com.example.demo.Entities.Aktivnost;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AktivnostRepositroy extends CrudRepository<Aktivnost, Integer> {

}