package com.fokatindia.booking_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private String status;       // "success" or "error"
    private int statusCode;      // e.g. 200, 400, 500
    private String message;      // human-readable message
    private T data;              // object or list
}