package br.edu.fema.tccacademia.repository;

import br.edu.fema.tccacademia.models.matricula.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MatriculaRepository extends JpaRepository<Matricula, UUID> {
}
