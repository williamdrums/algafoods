package com.wln.myrestaurantapi.di.notificacao;

import com.wln.myrestaurantapi.model.Cliente;

public interface Notificador {

    void notificar(Cliente cliente, String mensagem);

}
