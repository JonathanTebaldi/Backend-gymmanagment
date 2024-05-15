package br.edu.fema.tccacademia.controller;

import br.edu.fema.tccacademia.models.modalidade.*;
import br.edu.fema.tccacademia.repository.ModalidadeRepository;
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
@RequestMapping("modalidades")
public class ModalidadeController {

    @Autowired
    private ModalidadeRepository repository;

    @GetMapping
    public ResponseEntity<Page<DadosListagemModalidade>> listarTodos(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page =  repository.findAll(paginacao).map(DadosListagemModalidade::new);

        return ResponseEntity.ok(page);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroModalidade dados, UriComponentsBuilder uriBuilder){
        var modalidade = new Modalidade(dados);
        repository.save(modalidade);

        var uri = uriBuilder.path("modalidades/{id}").buildAndExpand(modalidade.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoModalidade(modalidade));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoModalidade dados){
        var modalidade = repository.getReferenceById(dados.id());
        modalidade.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoModalidade(modalidade));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable UUID id){
        var modalidade = repository.getReferenceById(id);
        modalidade.excluir();

        return ResponseEntity.noContent().build();
    }
}
