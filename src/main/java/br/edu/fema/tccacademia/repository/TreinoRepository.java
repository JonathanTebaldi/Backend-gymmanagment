package br.edu.fema.tccacademia.repository;

import br.edu.fema.tccacademia.models.treino.Treino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TreinoRepository extends JpaRepository<Treino, UUID> {
}
