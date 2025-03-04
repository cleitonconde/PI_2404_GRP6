package com.example.cadastro.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro.model.Professor;
import com.example.cadastro.service.ProfessorService;

@RestController
@RequestMapping("/api/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping("/{id}")
    public Optional<Professor> buscarPorId(@PathVariable Long id) {
        return professorService.buscarPorId(id);
    }

    @PostMapping
    public Professor salvar(@RequestBody Professor professor) {
        return professorService.salvar(professor);
    }

    @PutMapping("/{id}/atribuirDisciplina")
    public Professor atribuirDisciplina(@PathVariable Long id, @RequestParam String disciplina) {
        Optional<Professor> professor = professorService.buscarPorId(id);
        professor.ifPresent(p -> professorService.atribuirDisciplina(p, disciplina));
        return professor.orElse(null);
    }
}
