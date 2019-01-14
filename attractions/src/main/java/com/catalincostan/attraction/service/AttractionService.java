package com.catalincostan.attraction.service;

import com.catalincostan.attraction.domain.Attraction;
import com.catalincostan.attraction.repository.AttractionRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing Attraction.
 */
@Service
public class AttractionService {

    @Autowired
    private AttractionRepository repo;

    public List<Attraction> findAll() {
        return (List<Attraction>) repo.findAll();
    }

    public Optional<Attraction> findOne(Long id) {
        return repo.findById(id);
    }
}
