package com.dh.catalogservice.queue;


import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.Queue;

@Component
public class SerieSender {

    private final RabbitTemplate rabbitTemplate;
    private final Queue serieQueue;
    public void send(Serie serie) {this.rabbitTemplate.convertAndSend(this.serieQueue.getName(), serie);}
}
