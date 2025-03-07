package com.example.cadastro.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cadastro.dto.ProfessorDTO;
import com.example.cadastro.model.PessoaFisica;
import com.example.cadastro.model.Professor;
import com.example.cadastro.service.PessoaFisicaService;
import com.example.cadastro.service.ProfessorService;

@RestController
@RequestMapping("/api/professores")
@CrossOrigin(origins = "*") // Permite chamadas de qualquer origem (útil para testes locais)
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private PessoaFisicaService pessoaFisicaService;

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

    @PutMapping("/matricular")
    public ResponseEntity<Professor> matricularProfessor(@RequestBody ProfessorDTO professorDTO) {
        System.out.println("CPF: " + professorDTO.getCpf() + " Cursos: " + professorDTO.getDisciplinas());

        // Verificar se a Pessoa Física já existe com o CPF informado
        System.out.println("Buscando Pessoa Física com CPF: " + professorDTO.getCpf());
        Optional<PessoaFisica> pessoaFisicaOpt = pessoaFisicaService.buscarPorCpf(professorDTO.getCpf());

        if (pessoaFisicaOpt.isEmpty()) {
            System.out.println("Pessoa Física não encontrada!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        PessoaFisica pessoaFisica = pessoaFisicaOpt.get();
        Professor professor = new Professor();

        // Associar os dados da Pessoa Física ao Aluno
        professor.setCpf(pessoaFisica.getCpf());
        professor.setNome(pessoaFisica.getNome());
        professor.setDataNascimento(pessoaFisica.getDataNascimento());
        professor.setMatricula(professorService.gerarMatriculaUnica());

        for (String formacoes : professorDTO.getFormacoes()) {
            professor.matricularProfessor(formacoes);
        }

        // Salvar o aluno no banco de dados
        professorService.salvar(professor);

        // Retornar o aluno com a matrícula gerada
        return ResponseEntity.ok(professor);
    }
}
