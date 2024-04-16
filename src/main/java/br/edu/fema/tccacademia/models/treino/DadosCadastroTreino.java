package br.edu.fema.tccacademia.models.treino;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTreino(
        @NotBlank
        String nomeExercicio,
        @NotBlank
        String descricao,
        @NotBlank
        String series,
        @NotBlank
        String musculo
) {
}
