package com.wln.myrestaurantapi.domain.repository;

import com.wln.myrestaurantapi.domain.model.Cozinha;

import java.util.List;

public interface CozinhaRepository {
    List<Cozinha> listar();

    Cozinha buscarPorId(Long id);

    Cozinha salvar(Cozinha cozinha);

    void remover(Cozinha cozinha);
}
