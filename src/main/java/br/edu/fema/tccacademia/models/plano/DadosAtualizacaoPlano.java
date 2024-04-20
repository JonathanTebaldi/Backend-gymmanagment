package br.edu.fema.tccacademia.models.plano;

import br.edu.fema.tccacademia.models.modalidade.Modalidade;

import java.util.List;
import java.util.UUID;

public record DadosAtualizacaoPlano(
        UUID id,
        String descricao,
        Double preco,
        List<Modalidade> modalidades
) {
}
