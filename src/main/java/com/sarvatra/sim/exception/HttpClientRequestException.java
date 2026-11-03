package com.sarvatra.sim.exception;

import lombok.Getter;

@Getter
public class HttpClientRequestException extends RuntimeException {
    private final int statusCode;
    private final String url;

    public HttpClientRequestException(String message, String url, int statusCode, Throwable cause) {
        super(message, cause);
        this.url = url;
        this.statusCode = statusCode;
    }
}

