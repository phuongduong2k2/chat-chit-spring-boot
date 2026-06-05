package com.codewithnolan.chatchitflutter.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiError {
    private String message;
    private int statusCode;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime localDateTime;

    public ApiError(Builder builder) {
        this.message = builder.message;
        this.statusCode = builder.httpStatus.value();
        this.localDateTime = LocalDateTime.now();
    }

    public static class Builder {
        private String message;
        private HttpStatus httpStatus;

        public Builder(){};

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder withHttpStatus(HttpStatus httpStatus){
            this.httpStatus = httpStatus;
            return this;
        }

        public ApiError build() {
            return new ApiError(this);
        }
    }
}
