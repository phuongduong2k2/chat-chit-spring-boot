package com.codewithnolan.chatchitflutter.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MessageException extends RuntimeException{
    private final HttpStatus httpStatus;

    public MessageException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
