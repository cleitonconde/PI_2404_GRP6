package com.example.cadastro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro.model.PessoaJuridica;
import com.example.cadastro.repository.PessoaJuridicaRepository;
import com.example.cadastro.service.PessoaJuridicaService;

@RestController
@RequestMapping("/api/pessoas-juridicas")
@CrossOrigin(origins = "*")
public class PessoaJuridicaController {

    @Autowired
    private PessoaJuridicaService pessoaJuridicaService;

    // 1. Listar todas as pessoas jurídicas
    @GetMapping
    public ResponseEntity<List<PessoaJuridica>> listarTodos() {
        List<PessoaJuridica> pessoas = pessoaJuridicaService.listarTodos();
        return ResponseEntity.ok(pessoas);
    }

    // 2. Buscar uma pessoa jurídica pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<PessoaJuridica> buscarPorId(@PathVariable Long id) {
        Optional<PessoaJuridica> pessoaJuridica = pessoaJuridicaService.buscarPorId(id);
        return pessoaJuridica.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 3. Buscar uma pessoa jurídica pelo CNPJ
    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<PessoaJuridica> buscarPorCnpj(@PathVariable String cnpj) {
        Optional<PessoaJuridica> pessoaJuridica = pessoaJuridicaService.buscarPorCnpj(cnpj);
        return pessoaJuridica.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 4. Criar uma nova pessoa jurídica
    @PostMapping
    public ResponseEntity<PessoaJuridica> criar(@RequestBody PessoaJuridica pessoaJuridica) {
        PessoaJuridica novaPessoa = pessoaJuridicaService.salvar(pessoaJuridica);
        return ResponseEntity.ok(novaPessoa);
    }

    // 5. Atualizar uma pessoa jurídica
    @PutMapping("/{id}")
    public ResponseEntity<PessoaJuridica> atualizar(@PathVariable Long id,
            @RequestBody PessoaJuridica pessoaJuridicaAtualizada) {
        Optional<PessoaJuridica> pessoaExistente = pessoaJuridicaService.buscarPorId(id);
        if (pessoaExistente.isPresent()) {
            PessoaJuridica pessoa = pessoaExistente.get();
            pessoa.setNome(pessoaJuridicaAtualizada.getNome());
            pessoa.setRazaoSocial(pessoaJuridicaAtualizada.getRazaoSocial());
            pessoa.setCnpj(pessoaJuridicaAtualizada.getCnpj());
            pessoa.setInscricaoEstadual(pessoaJuridicaAtualizada.getInscricaoEstadual());
            return ResponseEntity.ok(pessoaJuridicaService.salvar(pessoa));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 6. Deletar uma pessoa jurídica
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<PessoaJuridica> pessoaExistente = pessoaJuridicaService.buscarPorId(id);
        if (pessoaExistente.isPresent()) {
            pessoaJuridicaService.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Autowired
    private PessoaJuridicaRepository pessoaJuridicaRepository;

    @GetMapping("/buscar")
    public ResponseEntity<List<PessoaJuridica>> buscarPessoaPorNome(@RequestParam String nome) {
        List<PessoaJuridica> pessoas = pessoaJuridicaRepository.findByNomeContaining(nome);
        return ResponseEntity.ok(pessoas);
    }
}
