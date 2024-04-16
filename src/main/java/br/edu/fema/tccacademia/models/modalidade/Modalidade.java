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
    private String descricao;
    private LocalDateTime diasDaSemana;
    private Funcionario funcionario;

    public Modalidade(DadosCadastroModalidade dados){
        this.descricao = dados.descricao();
        this.diasDaSemana = dados.diasDaSemana();
        this.funcionario = dados.funcionario();
    }

    public void adicionarProfessor(Funcionario funcionario){
        
    }
}
