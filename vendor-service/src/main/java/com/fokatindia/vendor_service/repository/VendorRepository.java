package com.fokatindia.vendor_service.repository;

import com.fokatindia.vendor_service.entity.Vendor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface VendorRepository extends ReactiveCrudRepository<Vendor, Long> {
    Mono<Vendor> findByUserId(Long userId);
}