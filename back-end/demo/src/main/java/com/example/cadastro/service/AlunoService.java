package com.example.cadastro.service;

import com.example.cadastro.model.Aluno;
import com.example.cadastro.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Optional<Aluno> buscarPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public void matricularAluno(Aluno aluno, String curso) {
        aluno.matricularAluno(curso);
        alunoRepository.save(aluno);
    }
}
