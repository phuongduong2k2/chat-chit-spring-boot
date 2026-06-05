package com.codewithnolan.chatchitflutter.controllers;

import com.codewithnolan.chatchitflutter.dtos.LoginFormDto;
import com.codewithnolan.chatchitflutter.dtos.RegisterFormDto;
import com.codewithnolan.chatchitflutter.entities.User;
import com.codewithnolan.chatchitflutter.services.AuthService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<User> login(@Valid @RequestBody LoginFormDto loginFormDto) {
        return new ResponseEntity<>(authService.login(loginFormDto), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterFormDto registerFormDto) {
        return new ResponseEntity<>(authService.register(registerFormDto),HttpStatus.OK);
    }

}
