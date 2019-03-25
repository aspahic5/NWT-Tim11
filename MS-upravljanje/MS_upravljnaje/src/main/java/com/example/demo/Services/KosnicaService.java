package com.example.demo.Services;

import java.util.Optional;

import com.example.demo.Entities.Kosnica;
import com.example.demo.Repositories.KosnicaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KosnicaService {

    @Autowired
    KosnicaRepository kosnicarepository;

    public Iterable<Kosnica> findAll() {
        return kosnicarepository.findAll();
    }

    public Optional<Kosnica> findById(int id) {
        return kosnicarepository.findById(id);
    }

    public String addKosnica(Kosnica k) {
        try {
            kosnicarepository.save(k);
        } catch (Exception e) {
            return e.toString();
        }
        return "Kosnica saved";
    }
}