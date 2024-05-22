package br.edu.fema.tccacademia.models.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    private UUID id;
    private String login;
    private String senha;

    public Usuario(String login, String senha) {
        this.id = UUID.randomUUID();
        this.login = login;
        this.senha = senha;
    }
}
