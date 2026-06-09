package com.codewithnolan.chatchitflutter.dtos;

import lombok.Getter;

@Getter
public class StatusResponse {
    private final String message;

    public StatusResponse(String message) {
        super();
        this.message = message;
    }
}
