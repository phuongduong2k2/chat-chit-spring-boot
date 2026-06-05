package com.codewithnolan.chatchitflutter.controllers;

import com.codewithnolan.chatchitflutter.dtos.user.LoginRequest;
import com.codewithnolan.chatchitflutter.dtos.user.LoginResponse;
import com.codewithnolan.chatchitflutter.dtos.user.RegisterRequest;
import com.codewithnolan.chatchitflutter.exceptions.ApiError;
import com.codewithnolan.chatchitflutter.exceptions.AuthException;
import com.codewithnolan.chatchitflutter.services.AuthService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {
    @NonNull private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        return new ResponseEntity<>(authService.login(loginRequest), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterRequest registerRequest) {
        return new ResponseEntity<>(authService.register(registerRequest),HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> handleAuthException(AuthException ex) {
        ApiError apiError = new ApiError
                .Builder()
                .withMessage(ex.getMessage())
                .withHttpStatus(ex.getHttpStatus())
                .build();
        return new ResponseEntity<>(apiError, HttpStatusCode.valueOf(apiError.getStatusCode()));
    }
}
