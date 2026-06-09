package com.codewithnolan.chatchitflutter.controllers;

import com.codewithnolan.chatchitflutter.dtos.StatusResponse;
import com.codewithnolan.chatchitflutter.dtos.message.MessageRequest;
import com.codewithnolan.chatchitflutter.dtos.message.MessageResponse;
import com.codewithnolan.chatchitflutter.exceptions.ApiError;
import com.codewithnolan.chatchitflutter.exceptions.MessageException;
import com.codewithnolan.chatchitflutter.services.MessageService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/v1/messages")
public class MessageController {
    @NonNull private MessageService messageService;

    @PostMapping("/{email}")
    public ResponseEntity<StatusResponse> createMessage(@Valid @RequestBody MessageRequest messageRequest, @PathVariable String email) {
        return new ResponseEntity<>(messageService.create(messageRequest, email), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<MessageResponse> getAll() {
        return new ResponseEntity<>(messageService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageResponse> getByUser(@PathVariable UUID id) {
        System.out.println(id);
        return new ResponseEntity<>(messageService.getByUser(id), HttpStatus.OK);
    }

    @ExceptionHandler(MessageException.class)
    public ResponseEntity<?> handleMessageException(MessageException ex) {
        ApiError apiError = new ApiError.Builder()
                .withMessage(ex.getMessage())
                .withHttpStatus(ex.getHttpStatus())
                .build();
        return new ResponseEntity<>(apiError ,ex.getHttpStatus());
    }

}
