package com.drohobytskyy.rabbitmq.rabbitmqdemo.service;

import com.drohobytskyy.rabbitmq.rabbitmqdemo.client.ConsumerClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("http")
@RequiredArgsConstructor
public class MessageSenderServiceHttp implements MessageSenderService {

    private final ConsumerClient consumerClient;

    @Override
    public void send(String message) {
        consumerClient.send(message);
    }

}
