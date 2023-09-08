package com.dh.movieservice.queue;


import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class MovieListener {

    private final MovieService movieService;
    public MovieListener(Movieservice service) { this.service = service; }
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
