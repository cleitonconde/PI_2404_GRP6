package com.example.cadastro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro.model.PessoaFisica;
import com.example.cadastro.repository.PessoaFisicaRepository;
import com.example.cadastro.service.PessoaFisicaService;

@RestController
@RequestMapping("/api/pessoas-fisicas")
@CrossOrigin(origins = "*") // Permite chamadas de qualquer origem (útil para testes locais)
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaService pessoaFisicaService;

    @PostMapping
    public ResponseEntity<String> salvarPessoa(@RequestBody PessoaFisica pessoaFisica) {
        Optional<PessoaFisica> existente = pessoaFisicaService.buscarPorCpf(pessoaFisica.getCpf());
        if (existente.isPresent()) {
            throw new RuntimeException("CPF já cadastrado!");
        }
        if (pessoaFisica.getCpf() == null || pessoaFisica.getCpf().isEmpty()) {
            return ResponseEntity.badRequest().body("CPF é obrigatório");
        }
        pessoaFisicaService.salvar(pessoaFisica);
        return ResponseEntity.ok(pessoaFisica.getNome() + " cadastrado com sucesso!");
    }

    @GetMapping("/{cpf}")
    public Optional<PessoaFisica> buscarPorCpf(@PathVariable String cpf) {
        return pessoaFisicaService.buscarPorCpf(cpf);
    }

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @GetMapping("/buscar")
    public ResponseEntity<List<PessoaFisica>> buscarPessoaPorNome(@RequestParam String nome) {
        List<PessoaFisica> pessoas = pessoaFisicaRepository.findByNomeContaining(nome);
        return ResponseEntity.ok(pessoas);
    }

}
