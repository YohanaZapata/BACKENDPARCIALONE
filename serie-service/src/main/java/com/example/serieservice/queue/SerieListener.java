/*
package com.example.serieservice.queue;


import com.example.serieservice.model.Serie;
import com.example.serieservice.service.SerieService;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;



@Component
public class SerieListener {

    private final SerieService service;
    public SerieListener(SerieService service) { this.service = service; }
    private static final Logger LOGGER = LoggerFactory.getLogger(SerieListener.class);

    @RabbitListener(queues = {"${queue.serie.name"})
    public void receive(@Payload Serie serie) {
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info(String.format("Received message -> %s", serie));
        service.save(serie);
    }

}

 */