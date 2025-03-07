package com.example.cadastro.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.cadastro.dto.AlunoDTO;
import com.example.cadastro.model.Aluno;
import com.example.cadastro.model.PessoaFisica;
import com.example.cadastro.service.AlunoService;
import com.example.cadastro.service.PessoaFisicaService;

@RestController
@RequestMapping("/api/alunos")
@CrossOrigin(origins = "*") // Permite chamadas de qualquer origem (útil para testes locais)
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private PessoaFisicaService pessoaFisicaService; // Injeção do serviço PessoaFisica

    @PutMapping("/matricular")
    public ResponseEntity<Aluno> matricularAluno(@RequestBody AlunoDTO alunoDTO) {
        System.out.println("CPF: " + alunoDTO.getCpf() + " Cursos: " + alunoDTO.getCursos());

        // Verificar se a Pessoa Física já existe com o CPF informado
        System.out.println("Buscando Pessoa Física com CPF: " + alunoDTO.getCpf());
        Optional<PessoaFisica> pessoaFisicaOpt = pessoaFisicaService.buscarPorCpf(alunoDTO.getCpf());

        if (pessoaFisicaOpt.isEmpty()) {
            // Se a Pessoa Física não for encontrada, retorna erro 404
            System.out.println("Pessoa Física não encontrada!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // Se a Pessoa Física existe, criamos o Aluno
        PessoaFisica pessoaFisica = pessoaFisicaOpt.get();
        Aluno aluno = new Aluno();

        // Associar os dados da Pessoa Física ao Aluno
        aluno.setCpf(pessoaFisica.getCpf());
        aluno.setNome(pessoaFisica.getNome());
        aluno.setDataNascimento(pessoaFisica.getDataNascimento());
        aluno.setMatricula(alunoService.gerarMatriculaUnica()); // Gerar matrícula única para o aluno

        // Matriculando o aluno nos cursos informados
        for (String curso : alunoDTO.getCursos()) {
            aluno.matricularAluno(curso);
        }

        // Salvar o aluno no banco de dados
        alunoService.salvar(aluno);

        // Retornar o aluno com a matrícula gerada
        return ResponseEntity.ok(aluno);
    }

}
