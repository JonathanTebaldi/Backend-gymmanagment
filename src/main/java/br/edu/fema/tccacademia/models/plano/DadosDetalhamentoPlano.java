package br.edu.fema.tccacademia.models.plano;

import br.edu.fema.tccacademia.models.modalidade.DadosDetalhamentoModalidade;
import br.edu.fema.tccacademia.models.modalidade.Modalidade;

import java.util.List;
import java.util.UUID;

public record DadosDetalhamentoPlano(
        UUID id,
        String nome,
        String descricao,
        Double preco,
        List<Modalidade> modalidades
) {
    public DadosDetalhamentoPlano(Plano plano){
        this(plano.getId(), plano.getNome(), plano.getDescricao(), plano.getPreco(), plano.getModalidades());
    }
}
