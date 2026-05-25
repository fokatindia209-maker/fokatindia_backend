package com.fokatindia.vendor_service.service;

import com.fokatindia.vendor_service.dto.CategoryRequest;
import com.fokatindia.vendor_service.dto.CategoryResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CategoryService {
    Mono<CategoryResponse> create(CategoryRequest request);

    Mono<CategoryResponse> getById(Long id);

    Flux<CategoryResponse> getAll();

    Mono<CategoryResponse> update(
            Long id,
            CategoryRequest request
    );

    Mono<Void> delete(Long id);
}
