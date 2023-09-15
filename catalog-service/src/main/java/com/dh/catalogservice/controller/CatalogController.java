package com.dh.catalogservice.controller;

import com.dh.catalogservice.Repository.IMovieRepository;
import com.dh.catalogservice.Repository.ISerieRepository;
import com.dh.catalogservice.Services.MovieService;
import com.dh.catalogservice.client.IMovieClient;
import com.dh.catalogservice.client.ISerieClient;


import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
public class CatalogController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private ISerieClient serieClient;

    @Autowired
    private IMovieRepository movieRepository;
    @Autowired
    private ISerieRepository serieRepository;


    @GetMapping("/catalog/{genre}")
    public ResponseEntity<List<Movie>> getCatalogByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(movieRepository.findByGenre(genre));
    }


    @PostMapping("/catalog/save")
    Movie saveMovie(@RequestBody Movie movie){
        return movieService.saveMovieService(movie);
    }

    @GetMapping("/catalog/find/{genre}")
    public ResponseEntity<List<Serie>> getCatalogByGenre2(@PathVariable String genre) {
        return ResponseEntity.ok(serieRepository.findByGenre(genre));
    }


    @PostMapping("/catalog/saveSerie")
    ResponseEntity<Serie> saveSerie(@RequestBody Serie serie){
        return serieClient.saveSerie(serie);
    }
}
