package br.edu.fema.tccacademia.models.aluno;

import br.edu.fema.tccacademia.enums.SexoEnum;
import br.edu.fema.tccacademia.models.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "Aluno")
@Table(name = "alunos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno{
    @Id
    private UUID id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private SexoEnum sexo;
    private String celular;
    private String cpf;
    private LocalDateTime dataNascimento;
    private String rg;
    @Embedded
    private Endereco endereco;
    private Boolean ativo;

    public Aluno(DadosCadastroAluno dados) {
        this.id = UUID.randomUUID();
        this.nome = dados.nome();
        this.sexo = dados.sexo();
        this.celular = dados.celular();
        this.cpf = dados.cpf();
        this.dataNascimento = dados.dataNascimento();
        this.rg = dados.rg();
        this.endereco = dados.endereco();
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoAluno dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.sexo() != null) {
            this.sexo = dados.sexo();
        }
        if(dados.celular() != null) {
            this.celular = dados.celular();
        }
        if(dados.cpf() != null) {
            this.cpf = dados.cpf();
        }
        if(dados.dataNascimento() != null) {
            this.dataNascimento = dados.dataNascimento();
        }
        if(dados.rg() != null) {
            this.rg = dados.rg();
        }
        if(dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }


    public void inativar(){
        this.ativo = false;
    }

    public void excluir(){

    }


}