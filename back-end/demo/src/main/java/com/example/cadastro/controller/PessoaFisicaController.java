package com.example.cadastro.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro.model.PessoaFisica;
import com.example.cadastro.service.PessoaFisicaService;

@RestController
@RequestMapping("/api/pessoas-fisicas")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @PostMapping
    public PessoaFisica salvar(@RequestBody PessoaFisica pessoaFisica) {
        Optional<PessoaFisica> existente = pessoaFisicaService.buscarPorCpf(pessoaFisica.getCpf());
        if (existente.isPresent()) {
            throw new RuntimeException("CPF já cadastrado!");
        }
        return pessoaFisicaService.salvar(pessoaFisica);
    }

    @GetMapping("/{cpf}")
    public Optional<PessoaFisica> buscarPorCpf(@PathVariable String cpf) {
        return pessoaFisicaService.buscarPorCpf(cpf);
    }
}
