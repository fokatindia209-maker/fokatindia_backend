package com.fokatindia.vendor_service.dto;

import lombok.Data;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.multipart.MultipartFile;

@Data
public class DocumentUploadRequest {
    private Long userId;

    // AADHAAR, PAN, GST, POLICE_VERIFICATION
    private String documentType;
    private FilePart file;
}
