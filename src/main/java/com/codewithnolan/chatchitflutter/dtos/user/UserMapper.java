package com.codewithnolan.chatchitflutter.dtos.user;

import com.codewithnolan.chatchitflutter.entities.User;

public class UserMapper {
    public static LoginResponse toLoginResponse(User user) {
        UserDto userData = new UserDto();
        userData.setEmail(user.getEmail());
        userData.setUsername(user.getUsername());
        userData.setAvatarName(user.getAvatarName());

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
        user.setAvatarName(registerRequest.getAvatarUrl());
        return user;
    }

    public static UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setAvatarName(user.getAvatarName());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
