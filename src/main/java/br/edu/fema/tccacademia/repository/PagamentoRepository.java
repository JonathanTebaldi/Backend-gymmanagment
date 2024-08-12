package br.edu.fema.tccacademia.repository;

import br.edu.fema.tccacademia.models.caixa.Caixa;
import br.edu.fema.tccacademia.models.caixa.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PagamentoRepository extends JpaRepository<Pagamento, UUID > {
    List<Pagamento> findByCaixa(Caixa caixa);
}
