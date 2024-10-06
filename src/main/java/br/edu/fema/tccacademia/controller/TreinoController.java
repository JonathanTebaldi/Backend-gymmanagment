package br.edu.fema.tccacademia.controller;

import br.edu.fema.tccacademia.models.treino.*;
import br.edu.fema.tccacademia.repository.TreinoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("treino")
public class TreinoController {

    @Autowired
    private TreinoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTreino dados, UriComponentsBuilder uriBuilder){
        var treino = new Treino(dados);
        repository.save(treino);

        var uri = uriBuilder.path("treinos/{id}").buildAndExpand(treino.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoTreino(treino));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoTreino dados){
        var treino = repository.getReferenceById(dados.id());
        treino.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoTreino(treino));
    }

    @GetMapping
    public ResponseEntity<List<Treino>> listar() {
        return ResponseEntity.ok(repository.findAll());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity inativar(@PathVariable UUID id){
        var treino = repository.getReferenceById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable UUID id){
        var treino = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTreino(treino));
    }
}
