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

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private CadastroCidadeService cadastroCidade;


    @GetMapping
    public List<Cidade> listar() {
        return cidadeRepository.listar();
    }


    @GetMapping("/{cidadeId}")
    public ResponseEntity<Cidade> buscarPorId(@PathVariable Long cidadeId) {

        Cidade cidade = cidadeRepository.buscarPorId(cidadeId);

        if (cidade != null) {
            return ResponseEntity.ok(cidade);
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

        Cidade cidadeAtual = cidadeRepository.buscarPorId(cidadeId);


        if (cidadeAtual != null) {
            //copia os dados de cidade para cidadeAtual(id é a propriedade ignorada para não ser copiada)
            BeanUtils.copyProperties(cidade, cidadeAtual, "id");

            cidadeAtual = cadastroCidade.salvar(cidadeAtual);
            return ResponseEntity.ok(cidadeAtual);
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
