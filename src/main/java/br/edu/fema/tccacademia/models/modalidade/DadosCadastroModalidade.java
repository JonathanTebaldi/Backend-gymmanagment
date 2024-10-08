package br.edu.fema.tccacademia.models.modalidade;

import br.edu.fema.tccacademia.models.funcionario.Funcionario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DadosCadastroModalidade(
        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        @NotNull
        String diasDaSemana,

        List<Funcionario> funcionario
) {
}
