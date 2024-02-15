package com.atipera.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> exception(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @ExceptionHandler(ResponseBodyFormatException.class)
    public ResponseEntity<Object> ResponseBodyFormatException(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
    @ExceptionHandler(ResponseNullException.class)
    public ResponseEntity<Object> ResponseNullException(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @ExceptionHandler(NoSuchRepositoryException.class)
    public ResponseEntity<Object> NoSuchRepositoryException(Exception ex) {
        Map<String, Object> resBody = new HashMap<String, Object>();
        resBody.put("message", "User not found");
        resBody.put("status", 404);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resBody);
    }
}