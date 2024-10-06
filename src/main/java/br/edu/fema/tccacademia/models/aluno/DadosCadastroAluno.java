package br.edu.fema.tccacademia.models.aluno;

import br.edu.fema.tccacademia.enums.SexoEnum;
import br.edu.fema.tccacademia.models.endereco.Endereco;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

public record DadosCadastroAluno(
        @NotBlank
        String nome,
        @NotNull
        SexoEnum sexo,
        @NotBlank
        String celular,
        @NotNull
        String cpf,
        LocalDateTime dataNascimento,
        String rg,

        Endereco endereco

) {
}
