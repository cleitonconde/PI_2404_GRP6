package com.example.cadastro.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro.model.PessoaFisica;
import com.example.cadastro.service.PessoaFisicaService2;

@RestController
@RequestMapping("/api/pessoas")
@CrossOrigin(origins = "*") // Permite chamadas de qualquer origem (útil para testes locais)
public class PessoaFisicaController2 {

    private final PessoaFisicaService2 pessoaFisicaService;

    public PessoaFisicaController2(PessoaFisicaService2 pessoaFisicaService) {
        this.pessoaFisicaService = pessoaFisicaService;
    }

    @PostMapping
    public ResponseEntity<String> cadastrarPessoa(@RequestBody PessoaFisica pessoa) {
        System.out.println("Recebido: " + pessoa);
        pessoaFisicaService.cadastrarPessoa(pessoa);
        return ResponseEntity.ok("Cadastro realizado com sucesso!!!!!");
    }

    @GetMapping
    public List<PessoaFisica> listarPessoas() {
        return pessoaFisicaService.listarPessoas();
    }
}
