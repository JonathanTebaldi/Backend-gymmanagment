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
    private String cargo;

    public Funcionario(DadosCadastroFuncionario dados){
        this.senha = dados.senha();
        this.cargo = dados.cargo();
    }

    public void excluir(){

    }
}
