package com.drohobytskyy.rabbitmq.consumer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageListenerService {

    @RabbitListener(queues = "myQueue")
    public void listen(String message) {
        log.info("Message has been received from myQueue : {}", message);
    }

}
