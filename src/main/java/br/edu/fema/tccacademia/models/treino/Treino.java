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

    public void adicionar(){

    }

}
