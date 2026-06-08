package com.codewithnolan.chatchitflutter.dtos.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class RegisterRequest {
    @NotBlank(message = "email is required")
    @Email(message = "email is invalid")
    private String email;

    @NotBlank(message = "username is required")
    private String username;

    @NotBlank(message = "password is required")
    @Size(min = 8,max=20, message = "password minimum length is 8")
    private String password;

    @Value("")
    private String avatarUrl;
}
