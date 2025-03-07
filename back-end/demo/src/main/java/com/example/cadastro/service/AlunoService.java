package com.example.cadastro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cadastro.model.Aluno;
import com.example.cadastro.repository.AlunoRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Long gerarMatriculaUnica() {
        Long ultimaMatricula = alunoRepository.findMaxMatricula().orElse(1000000000L);
        return ultimaMatricula + 1;
    }

    public Optional<Aluno> buscarPorCpf(String cpf) {
        // Buscando aluno pela CPF, já que o CPF está na classe PessoaFisica
        return alunoRepository.findByCpf(cpf);
    }

    public Optional<Aluno> buscarPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public void matricularAluno(Aluno aluno, String curso) {
        aluno.setMatricula(gerarMatriculaUnica());
        aluno.matricularAluno(curso);
        alunoRepository.save(aluno);
    }
}
