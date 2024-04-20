package br.edu.fema.tccacademia.controller;

import br.edu.fema.tccacademia.models.aluno.Aluno;
import br.edu.fema.tccacademia.models.aluno.DadosAtualizacaoAluno;
import br.edu.fema.tccacademia.models.aluno.DadosCadastroAluno;
import br.edu.fema.tccacademia.models.aluno.DadosListagemAluno;
import br.edu.fema.tccacademia.repository.AlunoRepository;
import jakarta.persistence.GeneratedValue;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("pessoa")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroAluno dados){
        repository.save(new Aluno(dados));
    }

    @GetMapping("/ativo")
    public Page<DadosListagemAluno> listarAtivo(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao){
        return repository.findByAtivoTrue(paginacao).map(DadosListagemAluno::new);
    }

    @GetMapping("/desativado")
    public Page<DadosListagemAluno> listarDesativo(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao){
        return repository.findByAtivoFalse(paginacao).map(DadosListagemAluno::new);
    }

    @GetMapping
    public Page<DadosListagemAluno> listarTodos(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemAluno::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoAluno dados){
        var aluno = repository.getReferenceById(dados.id());
        aluno.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity inativar(@PathVariable UUID id){
        var aluno = repository.getReferenceById(id);
        aluno.excluir();

        return ResponseEntity.noContent().build();
    }
}
