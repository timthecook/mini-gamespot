package com.tim.mini.gamespot.articleservice.exception;

public class ArticleNotFoundException extends RuntimeException{
    public ArticleNotFoundException(String message){
        super(message);
    }
}
