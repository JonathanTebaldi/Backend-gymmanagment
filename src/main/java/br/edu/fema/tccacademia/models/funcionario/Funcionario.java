package br.edu.fema.tccacademia.models.funcionario;

import br.edu.fema.tccacademia.models.modalidade.Modalidade;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "Funcionario")
@Table(name = "funcionarios")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {
    @Id
    private UUID id;
    private String nome;
    private String senha;
    private String cargo;

    @ManyToMany
    @JoinTable(
            name = "modalidade_funcionario", // nome da tabela intermediária
            joinColumns = @JoinColumn(name = "modalidade_id"), // chave estrangeira para Modalidade
            inverseJoinColumns = @JoinColumn(name = "funcionario_id") // chave estrangeira para Funcionario
    )
    private List<Funcionario> funcionario = new ArrayList<>();




    public Funcionario(DadosCadastroFuncionario dados){
        this.id = UUID.randomUUID();
        this.nome = dados.nome();
        this.senha = dados.senha();
        this.cargo = dados.cargo();
    }

    public void atualizarInformacoes(DadosAtualizacaoFuncionario dados){
        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.senha() != null) {
            this.senha = dados.senha();
        }
        if(dados.cargo() != null){
            this.cargo = dados.cargo();
        }
    }

    public void excluir(){

    }
}
