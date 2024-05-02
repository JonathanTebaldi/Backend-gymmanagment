package br.edu.fema.tccacademia.controller;

import br.edu.fema.tccacademia.models.treino.DadosAtualizacaoTreino;
import br.edu.fema.tccacademia.models.treino.DadosListagemTreino;
import br.edu.fema.tccacademia.repository.TreinoRepository;
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
@RequestMapping("treinos")
public class TreinoController {

    @Autowired
    private TreinoRepository repository;

    @PostMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoTreino dados){
        var treino = repository.getReferenceById(dados.id());
        treino.atualizarInformacoes(dados);
    }

    @GetMapping
    public Page<DadosListagemTreino> listar(@PageableDefault (page = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemTreino::new);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity inativar(@PathVariable UUID id){
        var treino = repository.getReferenceById(id);

        return ResponseEntity.noContent().build();
    }
}
