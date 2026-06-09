package com.codewithnolan.chatchitflutter.services;

import com.codewithnolan.chatchitflutter.dtos.StatusResponse;
import com.codewithnolan.chatchitflutter.dtos.message.MessageDto;
import com.codewithnolan.chatchitflutter.dtos.message.MessageMapper;
import com.codewithnolan.chatchitflutter.dtos.message.MessageResponse;
import com.codewithnolan.chatchitflutter.entities.Message;
import com.codewithnolan.chatchitflutter.entities.User;
import com.codewithnolan.chatchitflutter.repositories.MessageRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService{
    @NonNull private MessageRepository messageRepository;
    @NonNull private UserService userService;

    @Override
    public MessageResponse getAll() {
        List<MessageDto> messages = messageRepository
                .findAll()
                .stream()
                .map(MessageMapper::toDto)
                .toList();
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessages(messages);
        return messageResponse;
    }

    @Override
    public MessageResponse getByUser(UUID uuid) {
        List<MessageDto> messages = messageRepository
                .getByUser(uuid)
                .stream()
                .map(MessageMapper::toDto)
                .toList();
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessages(messages);
        return messageResponse;
    }

    @Override
    public StatusResponse create(String message, String username) {
        System.out.println(message + username);
        Optional<User> optionalUser = userService.getByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new EntityNotFoundException("User Not Found");
        }
        Message newMessage = new Message();
        newMessage.setMessage(message);
        newMessage.setUser(optionalUser.get());
        newMessage.setCreateAt(LocalDateTime.now());
        messageRepository.save(newMessage);
        return new StatusResponse("Message Created Success");
    }
}
