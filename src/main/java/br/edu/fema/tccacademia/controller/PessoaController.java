package br.edu.fema.tccacademia.controller;

import br.edu.fema.tccacademia.models.pessoa.Pessoa;
import br.edu.fema.tccacademia.repository.PessoaRepository;
import br.edu.fema.tccacademia.service.PessoaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

    @Autowired
    private PessoaService service;
    @Autowired
    private PessoaRepository repository;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pessoa>> getById (@PathVariable UUID id){
        var client = service.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(client);
    }

    @GetMapping
    public ResponseEntity<List<Clients>> getAll(){

        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/ativo")
    public ResponseEntity<List<Pessoa>> getAllAtivoByTrue(){
        List<Pessoa> activeClients = service.getAllByAtivo();
        return ResponseEntity.status(HttpStatus.OK).body(activeClients);
    }

    @PostMapping
    public ResponseEntity<Pessoa> create(@RequestBody @Valid PessoaDto clients){
        var clientInserted = new Clients(clients);
        service.create(clientInserted);
        final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clientInserted.getId()).toUri();

        return ResponseEntity.status(HttpStatus.CREATED).location(location).body(clientInserted);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Pessoa> update(@RequestBody @Valid ClientsUpdate clients){
        var client = repository.getReferenceById(clients.id());
        client.updateClients(clients);
        service.create(client);
        client.setId(clients.id());
        final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clients.id()).toUri();
        return ResponseEntity.status(HttpStatus.OK).location(location).body(client);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Optional<Pessoa>> delete (@PathVariable UUID id){
        var pessoa = repository.getReferenceById(id);
        pessoa.delete();

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
