package com.fokatindia.vendor_service.repository;


import com.fokatindia.vendor_service.entity.Category;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface CategoryRepository
        extends ReactiveCrudRepository<Category, Long> {
    Mono<Category> findByName(String name);

    Mono<Category> findBySlug(String slug);
}