package com.example.cadastro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cadastro.model.PessoaFisica;

@Service
public class PessoaFisicaService2 {
    private final List<PessoaFisica> pessoas = new ArrayList<>();

    public void cadastrarPessoa(PessoaFisica pessoa) {
        pessoas.add(pessoa);
    }

    public List<PessoaFisica> listarPessoas() {
        return pessoas;
    }
}
