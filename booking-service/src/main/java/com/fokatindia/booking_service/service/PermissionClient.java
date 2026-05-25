package com.fokatindia.booking_service.service;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class PermissionClient {

    private final WebClient webClient;

    public PermissionClient(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("http://localhost:8002") // API Gateway ONLY
                .build();
    }

    public Mono<List<String>> getPermissions(Long userId) {

        return webClient.get()
                .uri("/internal/permissions/{id}", userId)
                .retrieve()
                .onStatus(
                        status -> status.is4xxClientError() || status.is5xxServerError(),
                        response -> response.bodyToMono(String.class)
                                .flatMap(body -> Mono.error(
                                        new RuntimeException("user-service error: " + body)
                                ))
                )
                .bodyToMono(new ParameterizedTypeReference<List<String>>() {});
    }
}