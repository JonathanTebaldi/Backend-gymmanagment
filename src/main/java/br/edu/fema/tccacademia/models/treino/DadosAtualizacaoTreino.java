package br.edu.fema.tccacademia.models.treino;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record DadosAtualizacaoTreino(
        @NotBlank
        UUID id,
        String nomeExercicio,
        String descricao,
        String series,
        String musculo
) {
}
