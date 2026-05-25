package com.fokatindia.user_service.service;

import com.fokatindia.user_service.dto.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserService {

    Mono<UserResponse> registerUser(RegisterRequest request);

    Mono<UserResponse> registerVendor(RegisterRequest request);

    Mono<UserResponse> registerSubVendor(RegisterRequest request);
    Mono<UserResponse> login(LoginRequest request);

    Mono<ForgetPasswordResponse> forgotPassword(String email);
    Mono<UserResponse> getProfile(Long userId);
    Mono<UserResponse> updateProfile(Long id, RegisterRequest request);
    Mono<Void> deleteUser(Long id);


    Mono<UserResponse> deactivateUser(Long id);
    Mono<List<String>> getPermissions(Long userId);
    Flux<UserResponse> getAllUsers();






}
