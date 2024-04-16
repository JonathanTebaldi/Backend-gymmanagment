package br.edu.fema.tccacademia.models.aluno;

import br.edu.fema.tccacademia.enums.SexoEnum;
import br.edu.fema.tccacademia.models.endereco.Endereco;
import br.edu.fema.tccacademia.models.matricula.Matricula;
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
    @Embedded
    private Endereco endereco;
    private Boolean ativo;
    @OneToOne
    private Matricula matricula;

    public Aluno(DadosCadastroAluno dados) {
        this.nome = dados.nome();
        this.sexo = dados.sexo();
        this.celular = dados.celular();
        this.CPF = CPF;
        this.dataNascimento = dados.dataNascimento();
        this.rg = dados.rg();
        this.endereco = dados.endereco();
        this.ativo = true;
    }

    public void inativar(){
        this.ativo = false;
    }

    public void excluir(){

    }


}