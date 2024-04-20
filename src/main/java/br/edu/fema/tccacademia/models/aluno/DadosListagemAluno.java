package br.edu.fema.tccacademia.models.aluno;

import br.edu.fema.tccacademia.enums.SexoEnum;
import br.edu.fema.tccacademia.models.endereco.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

public record DadosListagemAluno(
        String nome,
        SexoEnum sexo,
        String celular,
        String cpf,
        LocalDateTime dataNascimento,
        String rg,
        Endereco endereco
) {

public DadosListagemAluno(Aluno aluno){
    this(aluno.getNome(), aluno.getSexo(), aluno.getCelular(),aluno.getCpf(),
        aluno.getDataNascimento(), aluno.getRg(),aluno.getEndereco());
}
}
