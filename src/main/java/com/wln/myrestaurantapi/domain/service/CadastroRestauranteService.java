package com.wln.myrestaurantapi.domain.service;


import com.wln.myrestaurantapi.domain.exception.EntidadeEmUsoException;
import com.wln.myrestaurantapi.domain.exception.EntidadeNaoEncontradaException;
import com.wln.myrestaurantapi.domain.model.Cozinha;
import com.wln.myrestaurantapi.domain.model.Restaurante;
import com.wln.myrestaurantapi.domain.repository.CozinhaRepository;
import com.wln.myrestaurantapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


@Service
public class CadastroRestauranteService {


    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Restaurante salvar(Restaurante restaurante) {

        Long cozinhaId = restaurante.getCozinha().getId();
        Cozinha cozinha = cozinhaRepository.findById(cozinhaId).orElseThrow(() ->
                new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de cozinha  com o código %d", cozinhaId)));

        restaurante.setCozinha(cozinha);
        return restauranteRepository.save(restaurante);
    }

    public void excluir(Long restauranteId) {

        try {
            restauranteRepository.deleteById(restauranteId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(String.format("Não existe um cadastro de restaurante com o código %d", restauranteId));

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format("Restaurante com código %d não pode ser removida, pois está em uso", restauranteId));
        }
    }
}
