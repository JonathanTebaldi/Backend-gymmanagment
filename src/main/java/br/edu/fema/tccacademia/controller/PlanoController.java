package br.edu.fema.tccacademia.controller;

import br.edu.fema.tccacademia.models.plano.DadosAtualizacaoPlano;
import br.edu.fema.tccacademia.models.plano.DadosCadastroPlano;
import br.edu.fema.tccacademia.models.plano.Plano;
import br.edu.fema.tccacademia.models.plano.DadosListagemPlano;
import br.edu.fema.tccacademia.repository.PlanoRepository;
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
@RequestMapping("plano")
public class PlanoController {

    @Autowired
    private PlanoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPlano dados){
        repository.save(new Plano(dados));
    }

    @GetMapping
    public Page<DadosListagemPlano> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemPlano::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPlano dados){
        var plano = repository.getReferenceById(dados.id());
        plano.atualizarInformacoes(dados);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable UUID id){
        var plano = repository.getReferenceById(id);
        plano.excluir();

        return ResponseEntity.noContent().build();
    }
}
