package com.wln.myrestaurantapi.infrastructure.repository;

import com.wln.myrestaurantapi.domain.model.Cozinha;
import com.wln.myrestaurantapi.domain.model.Estado;
import com.wln.myrestaurantapi.domain.repository.EstadoRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Component
public class EstadoRepositoryImpl implements EstadoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Estado> listar() {
        return manager.createQuery("from Estado", Estado.class)
                .getResultList();
    }

    @Override
    public Estado buscarPorId(Long id) {
        return manager.find(Estado.class, id);
    }

    @Transactional
    @Override
    public Estado salvar(Estado estado) {
        return manager.merge(estado);
    }

    @Transactional
    @Override
    public void remover(Estado estado) {
        estado = buscarPorId(estado.getId());
        manager.remove(estado);

    }
}
