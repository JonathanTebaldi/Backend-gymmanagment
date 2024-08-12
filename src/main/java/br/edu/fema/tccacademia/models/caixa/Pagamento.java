package br.edu.fema.tccacademia.models.caixa;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "Pagamento")
@Table(name = "pagamentos")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {
    private UUID id;
    private Double valor;
    private String descricao;
    @Temporal(TemporalType.TIME)
    private LocalDate Date;

    @ManyToOne
    private Caixa caixa;

}
