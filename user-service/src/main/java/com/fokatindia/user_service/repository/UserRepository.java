package com.fokatindia.user_service.repository;

import com.fokatindia.user_service.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {
    Mono<User> findByEmail(String email);

    Mono<User> findByPhone(String phone);
    Mono<User> findByInvitationCode(String invitationCode);

}
