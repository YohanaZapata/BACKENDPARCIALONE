package com.example.serieservice.SerieSender;

import com.example.serieservice.model.Serie;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class SerieSender {
    private final RabbitTemplate rabbitTemplate;
    private final Queue serieQueue;

    public SerieSender(RabbitTemplate rabbitTemplate, Queue serieQueue) {
        this.rabbitTemplate = rabbitTemplate;
        this.serieQueue = serieQueue;
    }

    public void send(Serie serie) {
        this.rabbitTemplate.convertAndSend(this.serieQueue.getName(), serie);
    }
}
