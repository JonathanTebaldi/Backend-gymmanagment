package br.edu.fema.tccacademia.controller;

import br.edu.fema.tccacademia.models.funcionario.DadosDetalhamentoFuncionario;
import br.edu.fema.tccacademia.models.funcionario.DadosAtualizacaoFuncionario;
import br.edu.fema.tccacademia.models.funcionario.DadosCadastroFuncionario;
import br.edu.fema.tccacademia.models.funcionario.DadosListagemFuncionario;
import br.edu.fema.tccacademia.models.funcionario.Funcionario;
import br.edu.fema.tccacademia.repository.FuncionarioRepository;
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
@RequestMapping("funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroFuncionario dados, UriComponentsBuilder uriBuilder){
        var funcionario = new Funcionario(dados);
        repository.save(funcionario);

        var uri = uriBuilder.path("funcionario/{id}").buildAndExpand(funcionario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoFuncionario(funcionario));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemFuncionario>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = repository.findAll(paginacao).map(DadosListagemFuncionario::new);

        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable UUID id){
        var funcionario = repository.getReferenceById(id);
        funcionario.excluir();

        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoFuncionario dados){
        var funcionario = repository.getReferenceById(dados.id());
        funcionario.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoFuncionario(funcionario));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable UUID id){
        var funcionario = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoFuncionario(funcionario));
    }
}
