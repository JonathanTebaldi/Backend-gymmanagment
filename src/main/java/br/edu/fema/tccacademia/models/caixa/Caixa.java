package br.edu.fema.tccacademia.models.caixa;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Entity(name = "Caixa")
@Table(name = "caixas")
@Getter
@EqualsAndHashCode(of = "id")
public class Caixa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private Double saldoAtual;
    private Double valorInicial;
    private Double valorFinal;
    private Date data;

    public void suprirCaixa(Double valor){
        this.saldoAtual = valor;
    }

    public void emitirNota(){

    }

    public void emitirHistoricoPagamento(){

    }

    public void emitirSegundaVia(){

    }
}
