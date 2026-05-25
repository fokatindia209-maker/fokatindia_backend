package com.fokatindia.user_service.service;

import com.fokatindia.user_service.dto.RolePermissionRequest;
import com.fokatindia.user_service.dto.RolePermissionResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RolePermissionService {
    Mono<RolePermissionResponse> assignPermission(RolePermissionRequest request);


    Flux<RolePermissionResponse> getAllRolePermissions();

    Mono<RolePermissionResponse> getById(Long id);

    Flux<RolePermissionResponse> getByRoleId(Long roleId);

    Mono<RolePermissionResponse> update(
            Long id,
            RolePermissionRequest request
    );

    Mono<Void> delete(Long id);
}
