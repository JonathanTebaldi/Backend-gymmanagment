package br.edu.fema.tccacademia.models.caixa;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "Pagamento")
@Table(name = "pagamentos")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Double valor;
    private String descricao;
    private LocalDateTime date;

    @ManyToOne
    private Caixa caixa;

    public Pagamento(Double valor, String descricao){
        this.valor = valor;
        this.descricao = descricao;
        this.date = LocalDateTime.now();
    }
}
