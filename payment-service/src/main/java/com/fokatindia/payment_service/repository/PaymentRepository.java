package com.fokatindia.payment_service.repository;

import com.fokatindia.payment_service.entity.Payment;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PaymentRepository extends ReactiveCrudRepository<Payment, Long> {

    Flux<Payment> findByUserId(Long userId);

    Flux<Payment> findByBookingId(Long bookingId);
}