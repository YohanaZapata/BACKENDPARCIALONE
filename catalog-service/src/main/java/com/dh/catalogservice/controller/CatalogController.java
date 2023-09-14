package com.dh.catalogservice.controller;

import com.dh.catalogservice.client.IMovieClient;
import com.dh.catalogservice.client.ISerieClient;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatalogController {

    @Autowired
    private IMovieClient movieClient;
    @Autowired
    private ISerieClient serieClient;


    @GetMapping("/catalog/{genre}")
    public ResponseEntity<List<Movie>> getCatalogByGenre(@PathVariable String genre) {
        return movieClient.getMovieByGenre(genre);
    }

    @PostMapping("/catalog/save")
    ResponseEntity<Movie> saveMovie(@RequestBody Movie movie){
        return movieClient.saveMovie(movie);
    }

    @GetMapping("/catalog/{genre}")
    public ResponseEntity<List<Serie>> getCatalogByGenre2(@PathVariable String genre) {
        return serieClient.getSerieByGenre(genre);
    }

    @PostMapping("/catalog/save")
    ResponseEntity<Serie> saveSerie(@RequestBody Serie serie){
        return serieClient.saveSerie(serie);
    }
}
