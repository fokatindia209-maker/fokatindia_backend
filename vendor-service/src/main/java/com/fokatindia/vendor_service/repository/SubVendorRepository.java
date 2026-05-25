package com.fokatindia.vendor_service.repository;

import com.fokatindia.vendor_service.entity.Document;
import com.fokatindia.vendor_service.entity.SubVendor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface SubVendorRepository  extends ReactiveCrudRepository<SubVendor, Long> {


    Flux<SubVendor> findByVendorId(Long vendorId);

    Flux<SubVendor> findByUserId(Long userId);
}