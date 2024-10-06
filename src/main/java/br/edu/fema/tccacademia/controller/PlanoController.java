package br.edu.fema.tccacademia.controller;

import br.edu.fema.tccacademia.models.plano.*;
import br.edu.fema.tccacademia.repository.PlanoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.DayOfWeek;
import java.util.UUID;

@RestController
@RequestMapping("plano")
public class PlanoController {

    @Autowired
    private PlanoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPlano dados, UriComponentsBuilder uriBuilder){
        var plano = new Plano(dados);

        repository.save(plano);

        var uri = uriBuilder.path("planos/{id}").buildAndExpand(plano.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoPlano(plano));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPlano>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = repository.findAll(paginacao).map(DadosListagemPlano::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPlano dados){
        var plano = repository.getReferenceById(dados.id());
        plano.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoPlano(plano));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable UUID id){
        var plano = repository.getReferenceById(id);
        plano.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable UUID id){
        var plano = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPlano(plano));
    }

}
