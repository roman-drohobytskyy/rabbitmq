package com.drohobytskyy.rabbitmq.consumer.controller;

import javax.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MessageController {

    @PostMapping(path = "/message")
    public void printMessage(@RequestBody @NotEmpty String message) {
        log.info("Message received via http: {}", message);
    }

}
