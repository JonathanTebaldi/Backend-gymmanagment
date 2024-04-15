package br.edu.fema.tccacademia.models.matricula;

import br.edu.fema.tccacademia.models.plano.Plano;
import br.edu.fema.tccacademia.models.aluno.Aluno;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "Matricula")
@Table(name = "matriculas")
@Getter
@Setter
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private Plano plano;
    private Aluno aluno;
}
