package com.codewithnolan.chatchitflutter.dtos.user;

import lombok.Data;

@Data
public class LoginResponse {
    private UserDto userData;
    private String accessToken;
}
