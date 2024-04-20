package br.edu.fema.tccacademia.models.treino;

import java.util.UUID;

public record DadosAtualizacaoTreino(
        UUID id,
        String nomeExercicio,
        String descricao,
        String series,
        String musculo
) {
}
