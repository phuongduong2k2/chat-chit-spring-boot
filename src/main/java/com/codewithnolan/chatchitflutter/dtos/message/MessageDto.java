package com.codewithnolan.chatchitflutter.dtos.message;

import com.codewithnolan.chatchitflutter.dtos.user.UserDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageDto {
    private String message;
    private LocalDateTime createdAt;
    private UserDto user;
}
