package com.example.cadastro.service;

import com.example.cadastro.model.PessoaFisica;
import com.example.cadastro.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PessoaFisicaService {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    public Optional<PessoaFisica> buscarPorCpf(String cpf) {
        return pessoaFisicaRepository.findByCpf(cpf);
    }

    public PessoaFisica salvar(PessoaFisica pessoaFisica) {
        return pessoaFisicaRepository.save(pessoaFisica);
    }
}
