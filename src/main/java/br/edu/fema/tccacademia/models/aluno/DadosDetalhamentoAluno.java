package br.edu.fema.tccacademia.models.aluno;

import br.edu.fema.tccacademia.enums.SexoEnum;
import br.edu.fema.tccacademia.models.endereco.Endereco;

import java.time.LocalDateTime;
import java.util.UUID;

public record DadosDetalhamentoAluno (
        UUID id,
        String nome,
        SexoEnum sexo,
        String celular,
        String cpf,
        LocalDateTime dataNascimento,
        String rg,
        Endereco endereco,
        Boolean ativo
){

    public DadosDetalhamentoAluno(Aluno aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getSexo(),
                aluno.getCelular(), aluno.getCpf(), aluno.getDataNascimento(),
                aluno.getRg(), aluno.getEndereco(), aluno.getAtivo());
    }
}
