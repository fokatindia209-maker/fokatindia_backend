package com.fokatindia.vendor_service.repository;

import com.fokatindia.vendor_service.entity.Document;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface DocumentRepository extends ReactiveCrudRepository<Document, Long> {
        Flux<Document> findByUserId(Long userId);
}