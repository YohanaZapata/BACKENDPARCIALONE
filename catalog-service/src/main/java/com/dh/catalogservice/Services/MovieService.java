package com.dh.catalogservice.Services;


import com.dh.catalogservice.Repository.IMovieRepository;
import com.dh.catalogservice.client.IMovieClient;
import com.dh.catalogservice.model.Movie;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MovieService {

    @Autowired
    private IMovieRepository movieRepository;

    @Autowired
    private IMovieClient movieClient;

    public Movie saveMovieCatalog(Movie movie) {
        return  movieRepository.save(movie);
    }

    @CircuitBreaker(name = "saveMovieService", fallbackMethod = "saveError")
    @Retry(name = "saveMovieService")
    public ResponseEntity<Movie> saveMovieService(Movie movie) {
        return movieClient.saveMovie(movie);
    }


    public ResponseEntity<Movie> saveError(Movie movie, CallNotPermittedException exception)
    {
        Movie movie2 = movieRepository.save(movie);
        log.info("FallBack -> Save error");
        return ResponseEntity.ok(movie2);
    }
}
