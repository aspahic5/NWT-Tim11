package com.example.demo.Repositories;

import com.example.demo.Entities.Rojenje;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RojenjeRepository extends CrudRepository<Rojenje,Integer> {

    @Query(value = "SELECT * FROM rojenje WHERE kosnica_id = :id", nativeQuery = true)
    public Iterable<Rojenje> dajRojenjaOdKosnice(@Param("id") int id);
}