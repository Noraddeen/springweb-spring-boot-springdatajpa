package com.example.demo.exeptionhundler;

public class RequestException extends RuntimeException {
    public RequestException(String messege) {
        super(messege);
    }

    public RequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
