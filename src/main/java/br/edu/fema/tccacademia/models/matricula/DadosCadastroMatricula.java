package br.edu.fema.tccacademia.models.matricula;

import br.edu.fema.tccacademia.models.aluno.Aluno;
import br.edu.fema.tccacademia.models.plano.Plano;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroMatricula(
        @NotNull
        Plano plano,
        @NotNull
        Aluno aluno
) {
}
