package com.example.demo.Services;

import java.util.Optional;

import com.example.demo.Entities.Selidba;
import com.example.demo.Repositories.SelidbaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelidbaService {

    @Autowired
    SelidbaRepository selidbaRepository;

    public Iterable<Selidba> findAll() {
        return selidbaRepository.findAll();
    }

    public Optional<Selidba> findById(int id) {
        return selidbaRepository.findById(id);
    }

    public String addSelidba(Selidba s) {
        try {
            selidbaRepository.save(s);
        } catch (Exception e) {
            return e.toString();
        }
        return "Selidba saved";
    }
}