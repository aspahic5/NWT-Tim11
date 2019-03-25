package com.example.demo.Services;

import java.util.Optional;

import com.example.demo.Entities.Rojenje;
import com.example.demo.Repositories.RojenjeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RojenjeService {

    @Autowired
    RojenjeRepository rojenjeRepository;

    public Iterable<Rojenje> findAll() {
        return rojenjeRepository.findAll();
    }

    public Optional<Rojenje> findById(int id) {
        return rojenjeRepository.findById(id);
    }

    public String addRojenje(Rojenje r) {
        try {
            rojenjeRepository.save(r);
        } catch (Exception e) {
            return e.toString();
        }
        return "Rojenje saved";
    }
}