package br.edu.fema.tccacademia.controller;

import br.edu.fema.tccacademia.models.funcionario.DadosAtualizacaoFuncionario;
import br.edu.fema.tccacademia.models.funcionario.DadosCadastroFuncionario;
import br.edu.fema.tccacademia.models.funcionario.DadosListagemFuncionario;
import br.edu.fema.tccacademia.models.funcionario.Funcionario;
import br.edu.fema.tccacademia.models.plano.DadosListagemPlano;
import br.edu.fema.tccacademia.repository.FuncionarioRepository;
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
@RequestMapping("funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroFuncionario dados){
        repository.save(new Funcionario(dados));
    }

    @GetMapping
    public Page<DadosListagemFuncionario> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemFuncionario::new);
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
    public void autualizar(@RequestBody @Valid DadosAtualizacaoFuncionario dados){
        var funcionario = repository.getReferenceById(dados.id());
        funcionario.atualizarInformacoes(dados);
    }

}
