package com.example.cadastro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro.model.Pessoa;
import com.example.cadastro.service.PessoaService;

@RestController
@RequestMapping("/api/pessoas")
@CrossOrigin(origins = "*") // Permite chamadas de qualquer origem (útil para testes locais)
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<Pessoa> listarTodas() {
        return pessoaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Optional<Pessoa> buscarPorId(@PathVariable String id) {
        return pessoaService.buscarPorId(id);
    }

    @PostMapping
    public Pessoa salvar(@RequestBody Pessoa pessoa) {
        return pessoaService.salvar(pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        pessoaService.deletar(id);
    }
}
