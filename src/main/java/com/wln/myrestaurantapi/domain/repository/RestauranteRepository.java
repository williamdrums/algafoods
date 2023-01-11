package com.wln.myrestaurantapi.domain.repository;

import com.wln.myrestaurantapi.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {

    List<Restaurante> listar();
    Restaurante buscarPorId(Long id);
    Restaurante salvar(Restaurante cozinha);
    void remover(Restaurante cozinha);
}
