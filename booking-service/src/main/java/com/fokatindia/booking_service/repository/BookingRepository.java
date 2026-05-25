package com.fokatindia.booking_service.repository;

import com.fokatindia.booking_service.entity.Booking;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface BookingRepository extends ReactiveCrudRepository<Booking, Long> {

    Flux<Booking> findByUserId(Long userId);

    Flux<Booking> findByVendorId(Long vendorId);

    Flux<Booking> findByBookingStatus(String bookingStatus);

    Flux<Booking> findByPaymentStatus(String paymentStatus);
}
