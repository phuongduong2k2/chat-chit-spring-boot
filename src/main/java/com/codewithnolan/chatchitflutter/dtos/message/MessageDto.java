package com.codewithnolan.chatchitflutter.dtos.message;

import com.codewithnolan.chatchitflutter.dtos.user.UserDto;
import lombok.Data;

@Data
public class MessageDto {
    private String message;
    private String createdAt;
    private UserDto user;
}
