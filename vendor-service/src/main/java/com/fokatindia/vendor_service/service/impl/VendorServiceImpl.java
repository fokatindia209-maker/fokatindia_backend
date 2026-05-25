package com.fokatindia.vendor_service.service.impl;

import com.fokatindia.vendor_service.dto.*;
import com.fokatindia.vendor_service.entity.Vendor;
import com.fokatindia.vendor_service.exception.ResourceNotFoundException;
import com.fokatindia.vendor_service.repository.VendorRepository;
import com.fokatindia.vendor_service.service.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepo;



    // =====================================================
    // VENDOR
    // =====================================================


    @Override
    public Mono<VendorResponse> createVendor(
            VendorRequest request
    ) {

        Vendor vendor = new Vendor();

        vendor.setUserId(request.getUserId());

        vendor.setBusinessName(
                request.getBusinessName()
        );

        vendor.setGstNumber(
                request.getGstNumber()
        );

        vendor.setAddress(
                request.getAddress()
        );

        vendor.setCity(
                request.getCity()
        );

        vendor.setServiceArea(
                request.getServiceArea()
        );

        vendor.setKycStatus("PENDING");

        vendor.setRating(0.0);

        vendor.setCreatedAt(LocalDateTime.now());

        return vendorRepo.save(vendor)

                .map(this::mapVendorResponse);
    }
    @Override
    public Mono<VendorResponse> getVendor(Long id) {

        return vendorRepo.findById(id)

                .switchIfEmpty(
                        Mono.error(
                                new ResourceNotFoundException(
                                        "Vendor not found"
                                )
                        )
                )

                .map(this::mapVendorResponse);
    }




    @Override
    public Mono<VendorResponse> getVendorByUserId(Long userId) {

        return vendorRepo.findByUserId(userId)

                .switchIfEmpty(
                        Mono.error(
                                new ResourceNotFoundException(
                                        "Vendor not found"
                                )
                        )
                )

                .map(this::mapVendorResponse);
    }

    @Override
    public Flux<VendorResponse> getAllVendors() {

        return vendorRepo.findAll()

                .map(this::mapVendorResponse);
    }

    @Override
    public Mono<VendorResponse> updateVendor(
            Long id,
            VendorRequest request
    ) {

        return vendorRepo.findById(id)

                .switchIfEmpty(
                        Mono.error(
                                new ResourceNotFoundException(
                                        "Vendor not found"
                                )
                        )
                )

                .flatMap(vendor -> {

                    if (request.getBusinessName() != null) {
                        vendor.setBusinessName(
                                request.getBusinessName()
                        );
                    }

                    if (request.getAddress() != null) {
                        vendor.setAddress(
                                request.getAddress()
                        );
                    }

                    if (request.getCity() != null) {
                        vendor.setCity(
                                request.getCity()
                        );
                    }

                    if (request.getServiceArea() != null) {
                        vendor.setServiceArea(
                                request.getServiceArea()
                        );
                    }

                    return vendorRepo.save(vendor);
                })

                .map(this::mapVendorResponse);
    }


    // =====================================================
    // MAPPERS
    // =====================================================

    private VendorResponse mapVendorResponse(
            Vendor vendor
    ) {

        return new VendorResponse(
                vendor.getVendorId(),
                vendor.getUserId(),
                vendor.getBusinessName(),
                vendor.getGstNumber(),
                vendor.getAddress(),
                vendor.getCity(),
                vendor.getServiceArea(),
                vendor.getKycStatus(),
                vendor.getRating()
        );
    }

}
