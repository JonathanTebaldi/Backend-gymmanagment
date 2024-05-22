package br.edu.fema.tccacademia.models.plano;

import br.edu.fema.tccacademia.models.modalidade.Modalidade;

import java.util.List;

public record DadosListagemPlano (
        String nome,
        String descricao,
        Double preco,
        List<Modalidade>modalidades
){
    public DadosListagemPlano(Plano plano){
        this(plano.getNome(), plano.getDescricao(), plano.getPreco(),
                plano.getModalidades());
    }
}
