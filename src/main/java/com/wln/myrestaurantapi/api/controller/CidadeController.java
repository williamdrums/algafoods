package com.wln.myrestaurantapi.api.controller;


import com.wln.myrestaurantapi.domain.exception.EntidadeEmUsoException;
import com.wln.myrestaurantapi.domain.exception.EntidadeNaoEncontradaException;
import com.wln.myrestaurantapi.domain.model.Cidade;
import com.wln.myrestaurantapi.domain.model.Cozinha;
import com.wln.myrestaurantapi.domain.repository.CidadeRepository;
import com.wln.myrestaurantapi.domain.service.CadastroCidadeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private CadastroCidadeService cadastroCidade;


    @GetMapping
    public List<Cidade> listar() {
        return cidadeRepository.findAll();
    }


    @GetMapping("/{cidadeId}")
    public ResponseEntity<Cidade> buscarPorId(@PathVariable Long cidadeId) {

        Optional<Cidade> cidade = cidadeRepository.findById(cidadeId);

        if (cidade.isPresent()) {
            return ResponseEntity.ok(cidade.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cidade salvar(@RequestBody Cidade cidade) {
        return cadastroCidade.salvar(cidade);
    }


    @PutMapping("/{cidadeId}")
    public ResponseEntity<Cidade> atualizar(@PathVariable Long cidadeId, @RequestBody Cidade cidade) {

        Optional<Cidade> cidadeAtual = cidadeRepository.findById(cidadeId);


        if (cidadeAtual.isPresent()) {
            //copia os dados de cidade para cidadeAtual(id é a propriedade ignorada para não ser copiada)
            BeanUtils.copyProperties(cidade, cidadeAtual.get(), "id");

            Cidade cidadeCadastrada = cadastroCidade.salvar(cidadeAtual.get());
            return ResponseEntity.ok(cidadeCadastrada);
        }

        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{cidadeId}")
    public ResponseEntity<Cidade> remover(@PathVariable Long cidadeId) {

        try {
            cadastroCidade.excluir(cidadeId);

            return ResponseEntity.noContent().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();


        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }
}
