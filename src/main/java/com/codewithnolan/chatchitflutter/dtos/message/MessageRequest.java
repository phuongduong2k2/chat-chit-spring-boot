package com.codewithnolan.chatchitflutter.dtos.message;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MessageRequest {
    @NotBlank(message = "message is required")
    private String message;

    @NotBlank(message = "createdAt is required")
    private String createdAt;
}
