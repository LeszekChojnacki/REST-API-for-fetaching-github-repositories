package com.atipera.api.exception;

public class ResponseBodyFormatException extends RuntimeException {
    public ResponseBodyFormatException(String msg) {
        super(msg);
    }
}
