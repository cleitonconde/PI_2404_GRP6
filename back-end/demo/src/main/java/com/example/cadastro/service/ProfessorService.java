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

    private Long gerarMatriculaUnica() {
        Long matricula;
        do {
            matricula = (long) (Math.random() * 9000000000L) + 1000000000L; // Gera um número de 10 dígitos
        } while (professorRepository.existsByMatricula(matricula)); // Garante unicidade

        return matricula;
    }

    public Optional<Professor> buscarPorId(Long id) {
        return professorRepository.findById(id.toString());
    }

    public Professor salvar(Professor professor) {
        return professorRepository.save(professor);
    }

    public void atribuirDisciplina(Professor professor, String disciplina) {
        professor.setMatricula(gerarMatriculaUnica());
        professor.atribuirDisciplina(disciplina);
        professorRepository.save(professor);
    }
}
