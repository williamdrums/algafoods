package com.wln.myrestaurantapi.domain.exception;

public class EntidadeNaoEncontradaException extends RuntimeException {


    public EntidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
