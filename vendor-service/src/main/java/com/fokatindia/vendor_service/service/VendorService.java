package com.fokatindia.vendor_service.service;

import com.fokatindia.vendor_service.dto.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VendorService {
    Mono<VendorResponse> createVendor(VendorRequest request);
    Mono<VendorResponse> getVendor(Long id);
    Flux<VendorResponse> getAllVendors();
    Mono<VendorResponse> updateVendor(Long id, VendorRequest request);
    Mono<VendorResponse> getVendorByUserId(Long userId);


}
