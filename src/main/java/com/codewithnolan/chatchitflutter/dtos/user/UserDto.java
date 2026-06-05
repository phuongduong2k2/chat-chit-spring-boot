package com.codewithnolan.chatchitflutter.dtos.user;

import lombok.Data;

@Data
public class UserDto {
    private String email;
    private String username;
    private String avatarUrl;
}
