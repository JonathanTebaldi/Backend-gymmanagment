package br.edu.fema.tccacademia.models.funcionario;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record DadosAtualizacaoFuncionario(
        @NotBlank
        UUID id,
        String nome,
        String senha,
        String cargo
) {
}
