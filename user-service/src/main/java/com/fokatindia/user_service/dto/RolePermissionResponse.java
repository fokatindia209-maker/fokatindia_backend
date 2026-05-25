package com.fokatindia.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolePermissionResponse {
    private Long id;
    private Long roleId;
    private Long permissionId;
}