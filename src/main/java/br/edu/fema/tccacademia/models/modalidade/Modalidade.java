package br.edu.fema.tccacademia.models.modalidade;

import br.edu.fema.tccacademia.models.funcionario.Funcionario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "modalidades")
@Entity(name = "Modalidade")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Modalidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String nome;
    private String descricao;
    private LocalDateTime diasDaSemana;
    @ManyToMany
    private Funcionario funcionario;

    public Modalidade(DadosCadastroModalidade dados){
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.diasDaSemana = dados.diasDaSemana();
        this.funcionario = dados.funcionario();
    }


    public void atualizarInformacoes(DadosAtualizacaoModalidade dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.descricao() != null){
            this.descricao = dados.descricao();
        }
        if (dados.diasDaSemana() != null){
            this.diasDaSemana = dados.diasDaSemana();
        }
        if (dados.funcionario() != null){
            this.funcionario = dados.funcionario();
        }
    }

    public void excluir() {
    }
}
