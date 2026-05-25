package com.fokatindia.user_service.service;

import com.fokatindia.user_service.dto.PermissionRequest;
import com.fokatindia.user_service.dto.PermissionResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PermissionService {


    // CREATE PERMISSION

    Mono<PermissionResponse> createPermission(
            PermissionRequest request
    );

    // GET ALL PERMISSIONS

    Flux<PermissionResponse> getAllPermissions();

    // GET PERMISSION BY ID

    Mono<PermissionResponse> getPermissionById(
            Long permissionId
    );

    // UPDATE PERMISSION

    Mono<PermissionResponse> updatePermission(
            Long permissionId,
            PermissionRequest request
    );

    // DELETE PERMISSION

    Mono<Void> deletePermission(
            Long permissionId
    );
}
