package com.codewithnolan.chatchitflutter.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
public class AuthException extends RuntimeException {
    final private HttpStatus httpStatus;

    public AuthException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
