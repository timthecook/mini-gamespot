package com.tim.mini.gamespot.commentservice.exception;

public class CommentNotFoundException extends RuntimeException{
    public CommentNotFoundException(String message){
        super(message);
    }
}
