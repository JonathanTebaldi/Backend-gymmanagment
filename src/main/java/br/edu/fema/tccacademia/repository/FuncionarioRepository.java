package br.edu.fema.tccacademia.repository;

import br.edu.fema.tccacademia.models.funcionario.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {
}
