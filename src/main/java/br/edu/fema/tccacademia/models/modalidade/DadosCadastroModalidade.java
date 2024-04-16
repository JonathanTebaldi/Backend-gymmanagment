package br.edu.fema.tccacademia.models.modalidade;

import br.edu.fema.tccacademia.models.funcionario.Funcionario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroModalidade(
        @NotBlank
        String descricao,
        @NotNull
        LocalDateTime diasDaSemana,
        @NotNull
        Funcionario funcionario
) {
}
