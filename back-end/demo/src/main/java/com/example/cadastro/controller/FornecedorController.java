package com.example.cadastro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro.model.Fornecedor;
import com.example.cadastro.service.FornecedorService;

@RestController
@RequestMapping("/fornecedores")
@CrossOrigin(origins = "*") // Permite chamadas de qualquer origem (útil para testes locais)
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    // Listar todos os fornecedores
    @GetMapping
    public ResponseEntity<List<Fornecedor>> listarFornecedores() {
        List<Fornecedor> fornecedores = fornecedorService.listarTodos();
        return new ResponseEntity<>(fornecedores, HttpStatus.OK);
    }

    // Buscar fornecedor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscarFornecedor(@PathVariable Long id) {
        Optional<Fornecedor> fornecedor = fornecedorService.buscarPorId(id);
        if (fornecedor.isPresent()) {
            return new ResponseEntity<>(fornecedor.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Criar um novo fornecedor
    @PostMapping
    public ResponseEntity<Fornecedor> criarFornecedor(@RequestBody Fornecedor fornecedor) {
        Fornecedor fornecedorCriado = fornecedorService.salvar(fornecedor);
        return new ResponseEntity<>(fornecedorCriado, HttpStatus.CREATED);
    }

    // Atualizar um fornecedor existente
    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> atualizarFornecedor(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        Optional<Fornecedor> fornecedorExistente = fornecedorService.buscarPorId(id);
        if (fornecedorExistente.isPresent()) {
            // fornecedor.setId(id); // Garantir que o ID seja o correto
            Fornecedor fornecedorAtualizado = fornecedorService.salvar(fornecedor);
            return new ResponseEntity<>(fornecedorAtualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Deletar um fornecedor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFornecedor(@PathVariable Long id) {
        Optional<Fornecedor> fornecedorExistente = fornecedorService.buscarPorId(id);
        if (fornecedorExistente.isPresent()) {
            fornecedorService.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
