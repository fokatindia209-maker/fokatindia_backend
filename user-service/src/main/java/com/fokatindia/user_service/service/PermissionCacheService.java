package com.fokatindia.user_service.service;

import com.fokatindia.user_service.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionCacheService {

    private final ReactiveRedisTemplate<String, Object> redisTemplate;
    private final PermissionRepository permissionRepository;

    public Mono<List<String>> getPermissions(Long userId) {

        String key = "permissions:user:" + userId;

        return redisTemplate.opsForValue()
                .get(key)

                .cast(List.class)

                .map(list -> (List<String>) list)

                .switchIfEmpty(

                        permissionRepository
                                .findPermissionsByUserId(userId)
                                .collectList()

                                .flatMap(permissions ->

                                        redisTemplate.opsForValue()
                                                .set(
                                                        key,
                                                        permissions,
                                                        Duration.ofHours(1)
                                                )
                                                .thenReturn(permissions)
                                )
                );
    }
}