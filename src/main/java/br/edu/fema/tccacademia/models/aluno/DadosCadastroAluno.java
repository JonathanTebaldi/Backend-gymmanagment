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
        @NotBlank
        SexoEnum sexo,
        @NotBlank
        String celular,
        @Pattern(regexp = "/^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$/")
        String cpf,
        LocalDateTime dataNascimento,
        String rg,
        @NotNull
        Endereco endereco

) {
}
