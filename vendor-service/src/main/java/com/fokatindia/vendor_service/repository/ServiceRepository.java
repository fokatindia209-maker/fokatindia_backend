package com.fokatindia.vendor_service.repository;

import com.fokatindia.vendor_service.entity.Service;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ServiceRepository
        extends ReactiveCrudRepository<Service, Long> {

    Flux<Service> findByCategoryId(Long categoryId);

    Flux<Service> findByActiveTrue();

    Flux<Service> findByFeaturedTrue();
}