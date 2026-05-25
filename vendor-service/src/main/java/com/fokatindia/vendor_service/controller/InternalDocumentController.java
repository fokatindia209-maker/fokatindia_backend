package com.fokatindia.vendor_service.controller;

import com.fokatindia.vendor_service.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/restful/v1/api/documents")
@RequiredArgsConstructor
public class InternalDocumentController {

    private final DocumentService service;

    @GetMapping("/status/{userId}")
    public Mono<String> getDocumentStatus(
            @PathVariable Long userId
    ) {
        return service.getDocumentStatus(userId);
    }
}