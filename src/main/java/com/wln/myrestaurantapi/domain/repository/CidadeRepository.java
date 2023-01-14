package com.wln.myrestaurantapi.domain.repository;

import com.wln.myrestaurantapi.domain.model.Cidade;

import java.util.List;

public interface CidadeRepository {

    List<Cidade> listar();

    Cidade buscarPorId(Long id);

    Cidade salvar(Cidade cidade);

    void remover(Cidade cidade);
}
