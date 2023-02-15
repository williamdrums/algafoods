package com.wln.myrestaurantapi.api.controller;

import com.wln.myrestaurantapi.domain.exception.EntidadeEmUsoException;
import com.wln.myrestaurantapi.domain.exception.EntidadeNaoEncontradaException;
import com.wln.myrestaurantapi.domain.model.Estado;
import com.wln.myrestaurantapi.domain.repository.EstadoRepository;
import com.wln.myrestaurantapi.domain.service.CadastroEstadoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CadastroEstadoService cadastroEstado;

    @GetMapping
    public List<Estado> listar() {
        return estadoRepository.findAll();
    }

    @GetMapping("/{estadoId}")
    public ResponseEntity<Estado> buscarPorId(@PathVariable Long estadoId) {

        Optional<Estado> estado = estadoRepository.findById(estadoId);

        if (estado.isPresent()) {
            return ResponseEntity.ok(estado.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estado adicionar(@RequestBody Estado estado) {

        return cadastroEstado.salvar(estado);
    }


    @PutMapping("/{estadoId}")
    public ResponseEntity<Estado> atualizar(@PathVariable Long estadoId, @RequestBody Estado estado) {

        Optional<Estado> estadoAtual = estadoRepository.findById(estadoId);

        if (estado != null) {

            //copia os dados de estado para estadoAtual(id é a propriedade ignorada para não ser copiada)
            BeanUtils.copyProperties(estado, estadoAtual.get(), "id");

            Estado estadoCadastrado = cadastroEstado.salvar(estadoAtual.get());
            return ResponseEntity.ok(estadoCadastrado);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{estadoid}")
    public ResponseEntity<?> deletar(@PathVariable Long estadoid) {

        try {

            cadastroEstado.excluir(estadoid);
            return ResponseEntity.noContent().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();

        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
