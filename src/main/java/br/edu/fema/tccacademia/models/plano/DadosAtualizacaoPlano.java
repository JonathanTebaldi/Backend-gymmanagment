package br.edu.fema.tccacademia.models.plano;

import br.edu.fema.tccacademia.models.modalidade.Modalidade;

import java.util.List;

public record DadosAtualizacaoPlano(
        String descricao,
        Double preco,
        List<Modalidade> modalidades
) {
}
