package com.example.serieservice.controller;

import com.example.serieservice.SerieSender.SerieSender;
import com.example.serieservice.model.Serie;
import com.example.serieservice.service.SerieService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
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
    private final SerieSender serieSender;

    public SerieController(SerieService serieService, SerieSender serieSender) {
        this.serieService = serieService;
        this.serieSender = serieSender;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Serie serie) {
        log.info("Serie Creada: " + serie.getName());
        serieService.create(serie);
        serieSender.send(serie);
        log.info("Serie Exitosamente: " + serie.getId());
        return serie.getId();
    }
}
