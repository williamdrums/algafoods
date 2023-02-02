package com.wln.myrestaurantapi.domain.exception;

public class EntidadeEmUsoException extends RuntimeException{

    public EntidadeEmUsoException(String mensagem){
        super(mensagem);
    }
}
