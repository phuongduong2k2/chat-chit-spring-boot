package com.codewithnolan.chatchitflutter.services;

import com.codewithnolan.chatchitflutter.dtos.StatusResponse;
import com.codewithnolan.chatchitflutter.dtos.message.MessageRequest;
import com.codewithnolan.chatchitflutter.dtos.message.MessageResponse;

import java.util.UUID;

public interface MessageService {
    MessageResponse getAll();

    MessageResponse getByUser(UUID uuid);

    StatusResponse create(MessageRequest messageRequest, String username);
}
