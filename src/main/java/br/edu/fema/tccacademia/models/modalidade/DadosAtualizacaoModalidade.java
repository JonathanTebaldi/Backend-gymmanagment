package br.edu.fema.tccacademia.models.modalidade;

import br.edu.fema.tccacademia.models.funcionario.Funcionario;
import jakarta.validation.constraints.NotBlank;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record DadosAtualizacaoModalidade(
        @NotBlank
        UUID id,
        String nome,
        String descricao,
        String diasDaSemana,
        List<Funcionario> funcionario
) {
}
