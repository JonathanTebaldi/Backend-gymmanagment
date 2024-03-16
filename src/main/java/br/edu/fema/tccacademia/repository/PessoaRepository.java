package br.edu.fema.tccacademia.repository;

import br.edu.fema.tccacademia.models.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {
}
