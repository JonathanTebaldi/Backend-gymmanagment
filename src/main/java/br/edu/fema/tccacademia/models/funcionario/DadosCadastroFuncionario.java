package br.edu.fema.tccacademia.models.funcionario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroFuncionario(
        @NotBlank
        String senha,
        @NotBlank
        String cargo
) {
}
