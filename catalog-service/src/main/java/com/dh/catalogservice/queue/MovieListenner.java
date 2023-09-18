package com.dh.catalogservice.queue;




import com.dh.catalogservice.Repository.IMovieRepository;
import com.dh.catalogservice.model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MovieListenner {
    private final IMovieRepository service;

    public MovieListenner(IMovieRepository service) {
        this.service = service;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieListenner.class);

    @RabbitListener(queues = {"${queue.movie.name}"})
    public void receive(@Payload Movie movie) {
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info(String.format("Received message -> %s", movie));
        service.save(movie);
    }
}
