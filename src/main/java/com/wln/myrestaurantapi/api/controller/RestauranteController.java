package com.wln.myrestaurantapi.api.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.wln.myrestaurantapi.domain.exception.EntidadeEmUsoException;
import com.wln.myrestaurantapi.domain.exception.EntidadeNaoEncontradaException;
import com.wln.myrestaurantapi.domain.model.Restaurante;
import com.wln.myrestaurantapi.domain.repository.CozinhaRepository;
import com.wln.myrestaurantapi.domain.repository.RestauranteRepository;
import com.wln.myrestaurantapi.domain.service.CadastroRestauranteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {


    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CadastroRestauranteService cadastroRestaurante;

    @GetMapping
    public List<Restaurante> listar() {
        return restauranteRepository.findAll();
    }

    @GetMapping("/{restauranteId}")
    public ResponseEntity<Restaurante> buscarPorId(@PathVariable Long restauranteId) {

        Optional<Restaurante> restaurante = restauranteRepository.findById(restauranteId);

        if (restaurante.isPresent()) {
            return ResponseEntity.ok(restaurante.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante) {

        try {

            restaurante = cadastroRestaurante.salvar(restaurante);
            return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }

    @PutMapping("/{restauranteId}")
    public ResponseEntity<Restaurante> atualizar(@PathVariable Long restauranteId, @RequestBody Restaurante restaurante) {

        Optional<Restaurante> restauranteAtual = restauranteRepository.findById(restauranteId);

        if (restauranteAtual != null) {
            //copia os dados de restaurante para restauranteAtual(id é a propriedade ignorada para não ser copiada)
            BeanUtils.copyProperties(restaurante, restauranteAtual.get(), "id");
            cadastroRestaurante.salvar(restauranteAtual.get());

            Restaurante restauranteCadastrado = cadastroRestaurante.salvar(restauranteAtual.get());
            return ResponseEntity.ok(restauranteCadastrado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{restauranteId}")
    public ResponseEntity<?> remover(@PathVariable Long restauranteId) {

        try {
            cadastroRestaurante.excluir(restauranteId);

            return ResponseEntity.noContent().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();

        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PatchMapping("/{restauranteId}")
    public ResponseEntity<?> atualizarParcial(@PathVariable Long restauranteId,
                                              @RequestBody Map<String, Object> campos) {
        Optional<Restaurante> restauranteAtual = restauranteRepository.findById(restauranteId);

        if (restauranteAtual.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        merge(campos, restauranteAtual.get());


        return atualizar(restauranteId, restauranteAtual.get());
    }

    private void merge(Map<String, Object> dadosOrigem, Restaurante restauranteDestino) {
        ObjectMapper objectMapper = new ObjectMapper();

        //cria um novo objeto do tipo da classe Restaurante
        Restaurante restauranteOrigem = objectMapper.convertValue(dadosOrigem, Restaurante.class);

        dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {
            Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade);
            field.setAccessible(true);//permite acessar um atributo privado de uma classe

            Object novoValor = ReflectionUtils.getField(field, restauranteOrigem);

            ReflectionUtils.setField(field, restauranteDestino, novoValor);
        });
    }
}
