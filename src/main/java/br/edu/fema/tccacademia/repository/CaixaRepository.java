package br.edu.fema.tccacademia.repository;

import br.edu.fema.tccacademia.models.caixa.Caixa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CaixaRepository extends JpaRepository<Caixa, UUID> {
}
