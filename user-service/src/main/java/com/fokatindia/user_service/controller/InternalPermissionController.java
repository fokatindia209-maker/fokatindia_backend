package com.fokatindia.user_service.controller;

import com.fokatindia.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/internal")
@RequiredArgsConstructor
public class InternalPermissionController {

    private final UserService userService;

    @GetMapping("/permissions/{userId}")
    public Mono<List<String>> getPermissions(@PathVariable Long userId) {

        return userService.getPermissions(userId);
    }
}