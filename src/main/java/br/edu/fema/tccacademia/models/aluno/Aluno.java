package br.edu.fema.tccacademia.models.aluno;

import br.edu.fema.tccacademia.enums.SexoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "Aluno")
@Table(name = "alunos")
@Getter
@Setter
public class Aluno{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private SexoEnum sexo;
    private String celular;
    private String CPF;
    private LocalDateTime dataNascimento;
    private String rg;
    private String endereco;
    private String bairro;
}