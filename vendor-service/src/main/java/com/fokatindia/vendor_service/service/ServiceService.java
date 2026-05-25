package com.fokatindia.vendor_service.service;

import com.fokatindia.vendor_service.dto.ServiceRequest;
import com.fokatindia.vendor_service.dto.ServiceResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServiceService {
    Mono<ServiceResponse> create(ServiceRequest request);

    Mono<ServiceResponse> getById(Long id);

    Flux<ServiceResponse> getAll();

    Flux<ServiceResponse> getByCategory(Long categoryId);

    Mono<ServiceResponse> update(Long id, ServiceRequest request);

    Mono<Void> delete(Long id);
}
