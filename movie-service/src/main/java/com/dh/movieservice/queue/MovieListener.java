package com.dh.movieservice.queue;


import com.dh.movieservice.model.Entity.Movie;
import com.dh.movieservice.service.MovieService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;



@Component
public class MovieListener {

    private final MovieService service;
    public MovieListener(MovieService service) { this.service = service; }
    private static final Logger LOGGER = LoggerFactory.getLogger(MovieListener.class);

    @RabbitListener(queues = {"${queue.movie.name"})
    public void receive(@Payload Movie movi) {
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info(String.format("Received message -> %s", movi));
        service.save(movi);
    }

}
