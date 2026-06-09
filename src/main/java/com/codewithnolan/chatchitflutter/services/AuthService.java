package com.codewithnolan.chatchitflutter.services;

import com.codewithnolan.chatchitflutter.dtos.StatusResponse;
import com.codewithnolan.chatchitflutter.dtos.user.LoginRequest;
import com.codewithnolan.chatchitflutter.dtos.user.LoginResponse;
import com.codewithnolan.chatchitflutter.dtos.user.RegisterRequest;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);

    StatusResponse register(RegisterRequest registerRequest);
}
