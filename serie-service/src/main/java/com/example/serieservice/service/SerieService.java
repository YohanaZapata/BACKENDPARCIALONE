package com.example.serieservice.service;

import com.example.serieservice.model.Serie;
import com.example.serieservice.repository.SerieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author vaninagodoy
 */

@Service
public class SerieService {

    private final SerieRepository repository;


    public SerieService(SerieRepository repository) {
        this.repository = repository;
    }

    public List<Serie> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Serie> getSeriesBygGenre(String genre) {
        return repository.findAllByGenre(genre);
    }

    public void save(Serie serie) {
        repository.save(serie);
    }

}
