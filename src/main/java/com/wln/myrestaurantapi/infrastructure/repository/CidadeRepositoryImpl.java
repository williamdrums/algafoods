package com.wln.myrestaurantapi.infrastructure.repository;


import com.wln.myrestaurantapi.domain.model.Cidade;
import com.wln.myrestaurantapi.domain.repository.CidadeRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CidadeRepositoryImpl implements CidadeRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cidade> listar() {
        return manager.createQuery("from Cidade ", Cidade.class).getResultList();
    }

    @Override
    public Cidade buscarPorId(Long cidadeId) {
        return manager.find(Cidade.class, cidadeId);
    }

    @Transactional
    @Override
    public Cidade salvar(Cidade cidade) {
        return manager.merge(cidade);
    }

    @Transactional
    @Override
    public void remover(Long cidadeId) {

        Cidade cidade = buscarPorId(cidadeId);

        if (cidade == null) {
            throw new EmptyResultDataAccessException(1);//1 é a quantidade que eu esperava que tivesse no objeto no caso uma cidade
        }
        manager.remove(cidade);
    }
}
