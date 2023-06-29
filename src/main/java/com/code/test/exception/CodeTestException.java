package com.code.test.exception;

import lombok.Getter;

@Getter
public class CodeTestException extends RuntimeException {
    private String message;

    public CodeTestException(String message) {
        this.message = message;
    }
}
