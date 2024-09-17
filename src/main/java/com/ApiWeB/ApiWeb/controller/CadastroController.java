package com.ApiWeB.ApiWeb.controller;

import com.ApiWeB.ApiWeb.model.Cadastros;
import com.ApiWeB.ApiWeb.model.DadosParaAtualizar;
import com.ApiWeB.ApiWeb.model.DadosParaCadastro;
import com.ApiWeB.ApiWeb.model.DadosParaListar;
import com.ApiWeB.ApiWeb.repository.CadastroRepository;
import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@CrossOrigin("*")
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private CadastroRepository repository;


    @Transactional
    @PostMapping
    public ResponseEntity<Cadastros> cadastrar(@RequestBody @Valid DadosParaCadastro dados, UriComponentsBuilder builder) {
        System.out.println("Dados recebidos: " + dados);
        var cadastrar = new Cadastros(dados);
        repository.save(cadastrar);
        var uri = builder.path("/cadastro/{id}").buildAndExpand(cadastrar.getId()).toUri();
        return ResponseEntity.created(uri).body(cadastrar);
    }

    @Transactional
    @GetMapping("/{id}")
    public ResponseEntity<DadosParaListar> listar(@PathVariable Long id) {
        var listar = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosParaListar(listar));
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<Cadastros> atualizar(@RequestBody @Valid DadosParaAtualizar dados) {
        var atualizarCadastros = repository.getReferenceById(dados.id());
        atualizarCadastros.atualizarinformacoes(dados);

        return ResponseEntity.status(HttpStatus.OK).body(repository.save(atualizarCadastros));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cadastro não existe");
        }

        repository.deleteById(id);
        return  ResponseEntity.noContent().build();
    }

}