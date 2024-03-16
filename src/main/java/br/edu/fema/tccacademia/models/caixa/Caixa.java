package br.edu.fema.tccacademia.models.caixa;

import java.util.Date;

public class Caixa {
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
