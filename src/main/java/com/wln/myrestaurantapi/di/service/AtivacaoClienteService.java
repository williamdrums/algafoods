package com.wln.myrestaurantapi.di.service;

import com.wln.myrestaurantapi.di.notificacao.Notificador;
import com.wln.myrestaurantapi.di.notificacao.NotificadorEmail;
import com.wln.myrestaurantapi.model.Cliente;
import org.springframework.stereotype.Controller;

@Controller
public class AtivacaoClienteService {

    private Notificador notificador;

    public AtivacaoClienteService(Notificador notificador) {
        this.notificador = notificador;

        System.out.println("AtivacaoClienteService: "+notificador);
    }

    public void ativar(Cliente cliente) {
        cliente.isAtivar();

        this.notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }
}
