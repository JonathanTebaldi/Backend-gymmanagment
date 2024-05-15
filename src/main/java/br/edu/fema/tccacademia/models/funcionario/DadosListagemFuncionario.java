package br.edu.fema.tccacademia.models.funcionario;

import br.edu.fema.tccacademia.models.plano.DadosListagemPlano;

public record DadosListagemFuncionario(
        String nome,
        String senha,
        String cargo
) {
    public DadosListagemFuncionario(Funcionario funcionario){
        this(funcionario.getNome(), funcionario.getSenha(), funcionario.getCargo());
    }
}
