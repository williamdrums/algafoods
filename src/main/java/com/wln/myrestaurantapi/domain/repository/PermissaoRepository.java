package com.wln.myrestaurantapi.domain.repository;

import com.wln.myrestaurantapi.domain.model.Permissao;

import java.util.List;

public interface PermissaoRepository {

    List<Permissao> listar();

    Permissao buscarPorId(Long id);

    Permissao salvar(Permissao cozinha);

    void remover(Permissao permissao);
}
