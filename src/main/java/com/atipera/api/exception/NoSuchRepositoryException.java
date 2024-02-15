package com.atipera.api.exception;

public class NoSuchRepositoryException extends RuntimeException {
    public NoSuchRepositoryException(String msg) {
        super(msg);
    }
}
