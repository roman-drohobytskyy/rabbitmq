package com.drohobytskyy.rabbitmq.consumer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Queue myQueue() {
        return new Queue("myQueue", false);
    }

}
