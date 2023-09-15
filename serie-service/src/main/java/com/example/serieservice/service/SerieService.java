package com.example.serieservice.service;

import com.example.serieservice.SerieSender.SerieSender;
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
    private final SerieSender sender;


    public SerieService(SerieRepository repository, SerieSender sender) {
        this.repository = repository;
        this.sender = sender;
    }

    public List<Serie> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Serie> getSeriesBygGenre(String genre) {
        return repository.findAllByGenre(genre);
    }


    public Serie create(Serie serie) {
        Serie serie2 = repository.save(serie);
        sender.send(serie2);
        return serie2;
    }
}
