/*
 * Schlumberger Private
 * © Copyright 2021 Schlumberger. All rights reserved
 */

package com.drohobytskyy.rabbitmq.rabbitmqdemo.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile("http")
@RequiredArgsConstructor
public class ConsumerClient {

    private static final String CONSUMER_URL = "http://localhost:8082";
    private static final String CONSUMER_PATH = "/message";
    private static final String POST_REQUEST_ERROR = "Error occurred while performing post request";

    private final HttpClient httpClient;

    public void send(String message) {
        String url = CONSUMER_URL + CONSUMER_PATH;
        HttpRequest httpRequest = buildPostHttpRequest(url, message);
        try {
            HttpResponse<String> response = httpClient.send(httpRequest, BodyHandlers.ofString());
            if (response.statusCode() == HttpStatus.OK.value()) {
                log.info("Consumer responded with status OK");
            } else {
                log.error("Consumer responded with status {}: {}", response.statusCode(), response.body());
            }
        } catch (Exception e) {
            log.error(POST_REQUEST_ERROR, e);
        }
    }

    private HttpRequest buildPostHttpRequest(String url, String requestBody) {
        return HttpRequest.newBuilder()
            .POST(HttpRequest.BodyPublishers.ofString(requestBody))
            .uri(URI.create(url))
            .header(HttpHeaders.CONTENT_TYPE, "text/plain")
            .build();
    }

}
