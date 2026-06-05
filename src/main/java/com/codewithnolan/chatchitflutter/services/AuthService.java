package com.codewithnolan.chatchitflutter.services;

import com.codewithnolan.chatchitflutter.dtos.LoginFormDto;
import com.codewithnolan.chatchitflutter.dtos.RegisterFormDto;
import com.codewithnolan.chatchitflutter.entities.User;

public interface AuthService {
    User login(LoginFormDto loginFormDto);

    String register(RegisterFormDto registerFormDto);
}
