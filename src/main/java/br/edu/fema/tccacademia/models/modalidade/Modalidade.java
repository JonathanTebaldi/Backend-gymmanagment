package br.edu.fema.tccacademia.models.modalidade;

import br.edu.fema.tccacademia.models.funcionario.Funcionario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
    private UUID id;
    private String nome;
    private String descricao;
    private String diasDaSemana;
    @ManyToMany
    private List<Funcionario> funcionario = new ArrayList<>();

    public Modalidade(DadosCadastroModalidade dados){
        this.id = UUID.randomUUID();
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.diasDaSemana = dados.diasDaSemana();
        this.funcionario = new ArrayList<>(dados.funcionario());
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
