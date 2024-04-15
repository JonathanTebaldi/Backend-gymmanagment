package br.edu.fema.tccacademia.models.funcionario;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity(name = "Funcionario")
@Table(name = "funcionarios")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String senha;
    private double salario;
    private String cargo;
}
