package com.codewithnolan.chatchitflutter.dtos.message;

import lombok.Data;

import java.util.List;

@Data
public class MessageResponse {
    private List<MessageDto> messages;
}
