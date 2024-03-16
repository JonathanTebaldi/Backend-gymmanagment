package br.edu.fema.tccacademia.repository;

import br.edu.fema.tccacademia.models.plano.Plano;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlanoRepository extends JpaRepository<Plano, UUID> {
}
