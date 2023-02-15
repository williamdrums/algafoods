package com.wln.myrestaurantapi.domain.service;


import com.wln.myrestaurantapi.domain.exception.EntidadeEmUsoException;
import com.wln.myrestaurantapi.domain.exception.EntidadeNaoEncontradaException;
import com.wln.myrestaurantapi.domain.model.Cidade;
import com.wln.myrestaurantapi.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroCidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;


    public Cidade salvar(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }


    public void excluir(Long cidadeId) {

        try {
            cidadeRepository.deleteById(cidadeId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de cidade com codigo %d ", cidadeId));

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format("Cidade de código %d não pode ser removida, pois está em uso", cidadeId));
        }
    }
}
