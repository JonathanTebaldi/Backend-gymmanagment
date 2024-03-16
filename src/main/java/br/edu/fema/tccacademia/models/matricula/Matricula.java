package br.edu.fema.tccacademia.models.matricula;

import br.edu.fema.tccacademia.models.plano.Plano;
import br.edu.fema.tccacademia.models.aluno.Aluno;
import lombok.Data;

import java.util.UUID;

@Data
public class Matricula {
    private UUID id;
    private Plano plano;
    private Aluno aluno;
}
