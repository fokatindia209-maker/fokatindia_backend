package com.fokatindia.vendor_service.service;

import com.fokatindia.vendor_service.dto.*;
import org.springframework.http.codec.multipart.FilePart;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SubVendorService {
    Mono<SubVendorResponse> addSubVendor(SubVendorRequest request);
    Flux<SubVendorResponse> getSubVendors(Long vendorId);
    Mono<SubVendorResponse> updateSubVendor(Long id, SubVendorRequest request);
    Flux<SubVendorResponse> getAllSubVendors();


}
