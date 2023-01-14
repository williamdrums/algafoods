package com.wln.myrestaurantapi.domain.repository;

import com.wln.myrestaurantapi.domain.model.FormaPagamento;

import java.util.List;

public interface FormaPagamentoRepository {

    List<FormaPagamento> listar();

    FormaPagamento BuscarPorId(Long id);

    FormaPagamento salvar(FormaPagamento formaPagamento);

    void remover(Long id);
}
