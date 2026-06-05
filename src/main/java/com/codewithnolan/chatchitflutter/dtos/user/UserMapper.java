package com.codewithnolan.chatchitflutter.dtos.user;

import com.codewithnolan.chatchitflutter.entities.User;

public class UserMapper {
    public static LoginResponse toLoginResponse(User user) {
        UserDto userData = new UserDto();
        userData.setEmail(user.getEmail());
        userData.setUsername(user.getUsername());
        userData.setAvatarUrl(user.getAvatarUrl());

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUserData(userData);
        loginResponse.setAccessToken("access token");
        return loginResponse;
    }

    public static User fromRegisterRequest(RegisterRequest registerRequest) {
        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setUsername(registerRequest.getUsername());
        user.setPassword(registerRequest.getPassword());
        user.setAvatarUrl(registerRequest.getAvatarUrl());
        return user;
    }
}
