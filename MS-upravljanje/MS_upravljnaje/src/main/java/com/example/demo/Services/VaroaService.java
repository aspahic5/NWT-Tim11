package com.example.demo.Services;

import java.util.Optional;

import com.example.demo.Entities.Varoa;
import com.example.demo.Repositories.VaroaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaroaService {

    @Autowired
    VaroaRepository varoaRepository;

    public Iterable<Varoa> findAll() {
        return varoaRepository.findAll();
    }

    public Optional<Varoa> findById(int id) {
        return varoaRepository.findById(id);
    }

    public String addVaroa(Varoa v) {
        try {
            varoaRepository.save(v);
        } catch (Exception e) {
            return e.toString();
        }
        return "Selidba saved";
    }
}