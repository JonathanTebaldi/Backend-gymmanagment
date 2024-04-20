package br.edu.fema.tccacademia.repository;

import br.edu.fema.tccacademia.models.aluno.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AlunoRepository extends JpaRepository<Aluno, UUID> {
    Page<Aluno> findByAtivoTrue(Pageable paginacao);

    Page<Aluno> findByAtivoFalse(Pageable paginacao);
}
