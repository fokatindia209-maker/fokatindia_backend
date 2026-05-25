package com.fokatindia.vendor_service.service.impl;

import com.fokatindia.vendor_service.dto.CategoryRequest;
import com.fokatindia.vendor_service.dto.CategoryResponse;
import com.fokatindia.vendor_service.entity.Category;
import com.fokatindia.vendor_service.entity.Vendor;
import com.fokatindia.vendor_service.exception.ResourceNotFoundException;
import com.fokatindia.vendor_service.repository.CategoryRepository;
import com.fokatindia.vendor_service.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl   implements CategoryService {

    private final CategoryRepository repository;


    // =====================================================
    // GET ALL CATEGORIES
    // =====================================================

    @Override
    public Flux<CategoryResponse> getAll() {

        return repository.findAll()
                .map(this::mapToResponse);
    }


    // =====================================================
    // DELETE CATEGORY
    // =====================================================

    @Override
    public Mono<Void> delete(
            Long id
    ) {

        return repository.findById(id)

                .switchIfEmpty(
                        Mono.error(
                                new ResourceNotFoundException(
                                        "Category not found"
                                )
                        )
                )

                .flatMap(repository::delete);
    }


    // =====================================================
    // GET CATEGORY BY ID
    // =====================================================

    @Override
    public Mono<CategoryResponse> getById(
            Long id
    ) {

        return repository.findById(id)

                .switchIfEmpty(
                        Mono.error(
                                new ResourceNotFoundException(
                                        "Category not found"
                                )
                        )
                )

                .map(this::mapToResponse);
    }





    // =====================================================
    // CREATE CATEGORY
    // =====================================================

    @Override
    public Mono<CategoryResponse> create(
            CategoryRequest request
    ) {

        return repository.findByName(request.getName())

                .flatMap(existing ->
                        Mono.error(
                                new RuntimeException(
                                        "Category already exists"
                                )
                        )
                )

                .switchIfEmpty(
                        Mono.defer(() -> {
                            Category category = new Category();

                            category.setName(
                                    request.getName()
                            );

                            category.setDescription(
                                    request.getDescription()
                            );

                            category.setImageUrl(
                                    request.getImageUrl()
                            );

                            category.setDisplayOrder(
                                    request.getDisplayOrder()
                            );

                            category.setSlug(
                                    request.getSlug()
                            );

                            category.setActive(true);

                            category.setCreatedAt(
                                    LocalDateTime.now()
                            );

                            category.setUpdatedAt(
                                    LocalDateTime.now()
                            );

                            return repository.save(category)
                                    .map(this::mapToResponse);
                        })
                )
                .cast(CategoryResponse.class);
    }


    // =====================================================
    // UPDATE CATEGORY
    // =====================================================

    @Override
    public Mono<CategoryResponse> update(
            Long id,
            CategoryRequest request
    ) {

        return repository.findById(id)

                .switchIfEmpty(
                        Mono.error(
                                new ResourceNotFoundException(
                                        "Category not found"
                                )
                        )
                )

                .flatMap(category -> {
                    if (request.getName() != null) {
                        category.setName(request.getName());
                    }

                    if (request.getDescription() != null) {
                        category.setDescription(
                                request.getDescription()
                        );
                    }

                    if (request.getImageUrl() != null) {
                        category.setImageUrl(
                                request.getImageUrl()
                        );
                    }

                    if (request.getDisplayOrder() != null) {
                        category.setDisplayOrder(
                                request.getDisplayOrder()
                        );
                    }
                    if (request.getSlug() != null) {
                        category.setSlug(
                                request.getSlug()
                        );
                    }


                    category.setUpdatedAt(LocalDateTime.now());
                    return repository.save(category);
                })

                .map(this::mapToResponse);
    }


    // =====================================================
    // MAPPER
    // =====================================================

    private CategoryResponse mapToResponse(
            Category category
    ) {

        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getImageUrl(),
                category.getDisplayOrder(),
                category.getActive(),
                category.getSlug(),
                category.getCreatedAt(),
                category.getUpdatedAt()
               );
    }
}
