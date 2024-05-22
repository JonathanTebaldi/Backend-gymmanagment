package br.edu.fema.tccacademia.models.funcionario;

import br.edu.fema.tccacademia.models.modalidade.Modalidade;
import jakarta.persistence.*;
import lombok.*;

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
    private List<Modalidade> modalidades;

    public Funcionario(DadosCadastroFuncionario dados){
        this.id = UUID.randomUUID();
        this.nome = dados.cargo();
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
