package br.edu.fema.tccacademia.repository;

import br.edu.fema.tccacademia.models.modalidade.Modalidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModalidadeRepository extends JpaRepository<Modalidade, UUID> {
}
