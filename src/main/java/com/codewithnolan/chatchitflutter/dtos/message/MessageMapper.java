package com.codewithnolan.chatchitflutter.dtos.message;

import com.codewithnolan.chatchitflutter.dtos.user.UserMapper;
import com.codewithnolan.chatchitflutter.entities.Message;

public class MessageMapper {
    public static MessageDto toDto(Message message) {
        MessageDto messageDto = new MessageDto();
        messageDto.setUser(UserMapper.toDto(message.getUser()));
        messageDto.setMessage(message.getMessage());
        messageDto.setCreatedAt(message.getCreateAt());
        return messageDto;
    }
}
