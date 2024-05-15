package br.edu.fema.tccacademia.controller;

import br.edu.fema.tccacademia.models.aluno.DadosDetalhamentoAluno;
import br.edu.fema.tccacademia.models.aluno.Aluno;
import br.edu.fema.tccacademia.models.aluno.DadosAtualizacaoAluno;
import br.edu.fema.tccacademia.models.aluno.DadosCadastroAluno;
import br.edu.fema.tccacademia.models.aluno.DadosListagemAluno;
import br.edu.fema.tccacademia.repository.AlunoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;


@RestController
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAluno dados, UriComponentsBuilder uriBuilder){
        var aluno = new Aluno(dados);
        repository.save(aluno);

        var uri = uriBuilder.path("/alunos/{id}").buildAndExpand(aluno).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoAluno(aluno));
    }

    @GetMapping("/ativo")
    public ResponseEntity<Page<DadosListagemAluno>> listarAtivo(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao){
        var page = repository.findByAtivoTrue(paginacao).map(DadosListagemAluno::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/desativado")
    public ResponseEntity<Page<DadosListagemAluno>> listarDesativo(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao){
        var page = repository.findByAtivoFalse(paginacao).map(DadosListagemAluno::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemAluno>> listarTodos(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemAluno::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoAluno dados){
        var aluno = repository.getReferenceById(dados.id());
        aluno.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoAluno(aluno));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity inativar(@PathVariable UUID id){
        var aluno = repository.getReferenceById(id);
        aluno.excluir();

        return ResponseEntity.noContent().build();
    }
}
