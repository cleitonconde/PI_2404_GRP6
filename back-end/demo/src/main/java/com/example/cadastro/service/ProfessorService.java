package com.example.cadastro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cadastro.model.Professor;
import com.example.cadastro.repository.ProfessorRepository;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Long gerarMatriculaUnica() {
        Long ultimaMatricula = professorRepository.findMaxMatricula().orElse(1000000000L);
        return ultimaMatricula + 1;
    }

    public Optional<Professor> buscarPorId(Long id) {
        return professorRepository.findById(id.toString());
    }

    public Professor salvar(Professor professor) {
        return professorRepository.save(professor);
    }

    /*
     * public void atribuirDisciplina(Professor professor, String disciplina) {
     * professor.setMatricula(gerarMatriculaUnica());
     * //professor.atribuirDisciplina(disciplina);
     * professorRepository.save(professor);
     * }
     */

    // public void matricularProfessor(Professor professor, String formacao, String
    // disciplina) {
    public void matricularProfessor(Professor professor, String formacao) {
        professor.setMatricula(gerarMatriculaUnica());
        professor.matricularProfessorFormacao(formacao);
        // professor.matricularProfessorDisciplina(disciplina);
        professorRepository.save(professor);
    }

}
