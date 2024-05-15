package br.edu.fema.tccacademia.models.treino;

import java.util.UUID;

public record DadosDetalhamentoTreino(
        UUID id,
        String nomeExercicio,
        String descricao,
        String series,
        String musculo
) {
    public DadosDetalhamentoTreino(Treino treino){
        this(treino.getId(), treino.getNomeExercicio(), treino.getDescricao(), treino.getSeries(), treino.getMusculo());
    }
}
