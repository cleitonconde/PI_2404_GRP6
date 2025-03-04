package com.example.cadastro.service;

import com.example.cadastro.model.Professor;
import com.example.cadastro.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Optional<Professor> buscarPorId(Long id) {
        return professorRepository.findById(id);
    }

    public Professor salvar(Professor professor) {
        return professorRepository.save(professor);
    }

    public void atribuirDisciplina(Professor professor, String disciplina) {
        professor.atribuirDisciplina(disciplina);
        professorRepository.save(professor);
    }
}
