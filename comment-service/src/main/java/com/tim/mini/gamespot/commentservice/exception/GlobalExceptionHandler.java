package com.tim.mini.gamespot.commentservice.exception;

import com.tim.mini.gamespot.commentservice.entity.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(CommentNotFoundException.class)
public ResponseEntity<Map<String, Object>> handleNotFound(CommentNotFoundException ex){
    Map<String, Object> body = new HashMap<>();
    body.put("timestamp", LocalDate.now());
    body.put("status", HttpStatus.NOT_FOUND.value());
    body.put("error", "Not Found");
    body.put("message", ex.getMessage());

    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
}

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneral(Exception ex){
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.put("error", "Not Found");
        body.put("message", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
