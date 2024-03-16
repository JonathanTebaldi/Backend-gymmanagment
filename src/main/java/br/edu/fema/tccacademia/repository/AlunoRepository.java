package br.edu.fema.tccacademia.repository;

import br.edu.fema.tccacademia.models.aluno.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlunoRepository extends JpaRepository<Aluno, UUID> {
}
