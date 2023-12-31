package com.dh.catalogservice.queue;



import com.dh.catalogservice.Repository.ISerieRepository;

import com.dh.catalogservice.model.Serie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class SerieListenner {
    private final ISerieRepository service;
    private static final Logger LOGGER = LoggerFactory.getLogger(SerieListenner.class);

    public SerieListenner(ISerieRepository service) {
        this.service = service;
    }

    @RabbitListener(queues = {"${queue.serie.name}"})
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
