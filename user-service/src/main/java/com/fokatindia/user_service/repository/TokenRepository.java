package com.fokatindia.user_service.repository;

import com.fokatindia.user_service.entity.Token;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface TokenRepository extends ReactiveCrudRepository<Token, Long> {
    Mono<Token> findByUserId(Long userId);
}
