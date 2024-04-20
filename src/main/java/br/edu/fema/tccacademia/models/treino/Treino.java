package br.edu.fema.tccacademia.models.treino;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "Treino")
@Table(name = "treinos")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Treino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String nomeExercicio;
    private String descricao;
    private String series;
    private String musculo;

    public Treino(DadosCadastroTreino dados){
        this.nomeExercicio = dados.nomeExercicio();
        this.descricao = dados.descricao();
        this.series = dados.series();
        this.musculo = dados.musculo();
    }

    public void atualizarInformacoes(DadosAtualizacaoTreino dados){
        if(dados.nomeExercicio() != null){
            this.nomeExercicio = dados.nomeExercicio();
        }
        if(dados.descricao() != null){
            this.descricao = dados.musculo();
        }
        if(dados.series() != null){
            this.series = dados.series();
        }
        if(dados.musculo() != null){
            this.musculo = dados.musculo();
        }
    }

}
