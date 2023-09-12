package com.dh.catalogservice.config;


import lombok.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSenderConfig {

    @Value("${queue.serie.name}")
    private String serieQueue;

    public String getSerieQueue() {
        return serieQueue;
    }
}
