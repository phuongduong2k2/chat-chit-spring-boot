package com.codewithnolan.chatchitflutter.services;

import com.codewithnolan.chatchitflutter.dtos.user.LoginRequest;
import com.codewithnolan.chatchitflutter.dtos.user.LoginResponse;
import com.codewithnolan.chatchitflutter.dtos.user.RegisterRequest;
import com.codewithnolan.chatchitflutter.dtos.user.RegisterResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);

    RegisterResponse register(RegisterRequest registerRequest);
}
