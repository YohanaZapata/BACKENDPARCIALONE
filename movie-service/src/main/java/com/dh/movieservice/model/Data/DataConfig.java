package com.dh.movieservice.model.Data;

import com.dh.movieservice.model.Entity.Movie;
import com.dh.movieservice.repository.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class DataConfig implements ApplicationRunner {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Movie movie = new Movie();
        movie.setName("Avengers");
        movie.setGenre("Accion");
        movie.setUrlStream("www.avenger.com");
        Movie saveMovie = movieRepository.save(movie);
        Movie managedMovie = new Movie();
        managedMovie.setId(saveMovie.getId());
    }
}
