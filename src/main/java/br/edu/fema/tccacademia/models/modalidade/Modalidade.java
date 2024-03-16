package br.edu.fema.tccacademia.models.modalidade;

import br.edu.fema.tccacademia.models.funcionario.Funcionario;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Modalidade {
    private UUID id;
    private String descricao;
    private LocalDateTime diasDaSemana;
    private Funcionario funcionario;

    public void adicionarProfessor(Funcionario funcionario){
        
    }
}
