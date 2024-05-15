package br.edu.fema.tccacademia.models.funcionario;


import java.util.UUID;

public record DadosDetalhamentoFuncionario(
        UUID id,
        String nome,
        String senha,
        String cargo
) {
    public DadosDetalhamentoFuncionario(Funcionario funcionario){
        this(funcionario.getId(), funcionario.getNome(), funcionario.getSenha(), funcionario.getCargo());
    }
}
