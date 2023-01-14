package com.wln.myrestaurantapi.domain.repository;

import com.wln.myrestaurantapi.domain.model.Estado;

import java.util.List;

public interface EstadoRepository {

    List<Estado> listar();

    Estado buscarPorId(Long id);

    Estado salvar(Estado estado);

    void remover(Estado estado);
}
