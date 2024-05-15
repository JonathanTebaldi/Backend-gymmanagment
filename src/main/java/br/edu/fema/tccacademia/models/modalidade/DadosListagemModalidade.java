package br.edu.fema.tccacademia.models.modalidade;

import br.edu.fema.tccacademia.models.funcionario.Funcionario;
import br.edu.fema.tccacademia.models.plano.DadosListagemPlano;

import java.time.LocalDateTime;

public record DadosListagemModalidade(
        String nome,
        String descricao,
        LocalDateTime diasDaSemana,
        Funcionario funcionario
) {

    public DadosListagemModalidade(Modalidade modalidade){
        this(modalidade.getNome(), modalidade.getDescricao(),
                modalidade.getDiasDaSemana(), modalidade.getFuncionario());
    }
}
