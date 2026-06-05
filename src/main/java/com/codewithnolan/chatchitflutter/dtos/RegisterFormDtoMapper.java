package com.codewithnolan.chatchitflutter.dtos;

import com.codewithnolan.chatchitflutter.entities.User;

public class RegisterFormDtoMapper {
    public static User mapDtoToEntity(RegisterFormDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setAvatarUrl(dto.getAvatarUrl());
        return user;
    }
}
