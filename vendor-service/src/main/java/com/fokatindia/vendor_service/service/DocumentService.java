package com.fokatindia.vendor_service.service;

import com.fokatindia.vendor_service.dto.DocumentResponse;
import com.fokatindia.vendor_service.dto.DocumentUploadRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DocumentService {
    Mono<DocumentResponse> uploadDocument(DocumentUploadRequest request);
    Mono<DocumentResponse> verifyDocument(Long id, String status);
    Flux<DocumentResponse> getUserDocuments(Long userId);

    Mono<String> getDocumentStatus(Long userId);
    Flux<DocumentResponse> getAllDocuments();
}
