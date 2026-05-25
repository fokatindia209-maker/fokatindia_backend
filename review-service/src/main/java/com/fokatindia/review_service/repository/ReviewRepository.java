package com.fokatindia.review_service.repository;

import com.fokatindia.review_service.entity.Review;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
@Repository
public interface ReviewRepository extends ReactiveCrudRepository<Review, Long> {

    Flux<Review> findByVendorId(Long vendorId);

    Flux<Review> findByServiceId(Long serviceId);

    Flux<Review> findByUserId(Long userId);
}