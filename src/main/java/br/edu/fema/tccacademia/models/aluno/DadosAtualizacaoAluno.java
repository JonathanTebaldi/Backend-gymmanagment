package br.edu.fema.tccacademia.models.aluno;

import br.edu.fema.tccacademia.enums.SexoEnum;
import br.edu.fema.tccacademia.models.endereco.DadosEndereco;
import br.edu.fema.tccacademia.models.endereco.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;
import java.util.UUID;

public record DadosAtualizacaoAluno(
        @NotBlank
        UUID id,
        String nome,
        SexoEnum sexo,
        String celular,
        String cpf,
        LocalDateTime dataNascimento,
        String rg,
        DadosEndereco endereco

) {
}
