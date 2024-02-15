package com.atipera.api.exception;

public class ResponseNullException extends IllegalArgumentException {
    public ResponseNullException(String msg) {
        super(msg);
    }
}
