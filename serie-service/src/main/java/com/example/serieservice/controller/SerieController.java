package com.example.serieservice.controller;

import com.example.serieservice.model.Serie;
import com.example.serieservice.service.SerieService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author vaninagodoy
 */

@RestController
@RequestMapping("/api/v1/series")
@Log4j2
public class SerieController {

    private final SerieService serieService;

    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping
    public List<Serie> getAll() {
        log.info("Busqueda de todas series: ");
        return serieService.getAll();
    }

    @GetMapping("/{genre}")
    public List<Serie> getSerieByGenre(@PathVariable String genre) {
        log.info("Busqueda de serie por genero: " + genre);
        return serieService.getSeriesBygGenre(genre);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Serie>create(@RequestBody Serie serie) {
        return ResponseEntity.ok(serieService.create(serie));
    }

}
