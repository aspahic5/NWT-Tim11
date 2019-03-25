package com.example.demo.Services;

import java.util.Optional;

import com.example.demo.Entities.Aktivnost;
import com.example.demo.Repositories.AktivnostRepositroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AktivnostService {

    @Autowired
    AktivnostRepositroy aktivnostrepository;

    public Iterable<Aktivnost> findAll() {
        return aktivnostrepository.findAll();
    }

    public Optional<Aktivnost> findById(int id) {
        return aktivnostrepository.findById(id);
    }

    public String addAktivnost(Aktivnost a){

        try {
            aktivnostrepository.save(a);
        } catch (Exception e) {
            return e.toString();
        }
        return "Aktivnost saved";
    }
}