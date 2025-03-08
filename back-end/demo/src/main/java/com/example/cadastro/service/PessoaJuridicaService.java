package com.example.cadastro.service;

import com.example.cadastro.model.PessoaJuridica;
import com.example.cadastro.repository.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaJuridicaService {

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    public List<PessoaJuridica> listarTodos() {
        return pessoaJuridicaRepository.findAll();
    }

    public Optional<PessoaJuridica> buscarPorId(Long id) {
        return pessoaJuridicaRepository.findById(id);
    }

    public Optional<PessoaJuridica> buscarPorCnpj(String cnpj) {
        return pessoaJuridicaRepository.findByCnpj(cnpj);
    }

    public PessoaJuridica salvar(PessoaJuridica pessoaJuridica) {
        return pessoaJuridicaRepository.save(pessoaJuridica);
    }

    public void deletar(Long id) {
        pessoaJuridicaRepository.deleteById(id);
    }
}
