package br.edu.fema.tccacademia.models.caixa;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity(name = "Caixa")
@Table(name = "caixas")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Caixa {
    @Id
    private UUID id;
    private Double saldoAtual;
    private Double valorInicial;
    private Double valorFinal;
    @Temporal(TemporalType.TIME)
    private LocalDate data;

    public Caixa(Double saldoAtual, Double valorInicial, Double valorFinal, Date data) {
        this.id = UUID.randomUUID();
        this.saldoAtual = saldoAtual;
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
        this.data = LocalDate.now();
    }

}
