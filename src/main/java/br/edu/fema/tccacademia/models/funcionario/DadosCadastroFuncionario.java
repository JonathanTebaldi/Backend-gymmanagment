package br.edu.fema.tccacademia.models.funcionario;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroFuncionario(
        @NotBlank
        String nome,
        @NotBlank
        String senha,
        @NotBlank
        String cargo
) {
}
