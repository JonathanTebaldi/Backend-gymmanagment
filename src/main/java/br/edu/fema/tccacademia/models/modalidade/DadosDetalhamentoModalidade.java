package br.edu.fema.tccacademia.models.modalidade;

import br.edu.fema.tccacademia.models.funcionario.Funcionario;

import java.time.LocalDateTime;
import java.util.UUID;

public record DadosDetalhamentoModalidade(
        UUID id,
        String nome,
        String descricao,
        LocalDateTime diasDaSemana,
        Funcionario funcionario
) {
    public DadosDetalhamentoModalidade(Modalidade modalidade) {
        this(modalidade.getId(), modalidade.getNome(), modalidade.getDescricao(),
                modalidade.getDiasDaSemana(), (Funcionario) modalidade.getFuncionario());
    }
}
