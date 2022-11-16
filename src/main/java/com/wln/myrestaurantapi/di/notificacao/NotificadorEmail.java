package com.wln.myrestaurantapi.di.notificacao;

import com.wln.myrestaurantapi.model.Cliente;
import org.springframework.stereotype.Component;


@Component
public class NotificadorEmail implements Notificador {


    public NotificadorEmail() {
    }

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s atraves do e-mail %s: %s\n",
                cliente.getNome(), cliente.getEmail(), mensagem);
    }
}
