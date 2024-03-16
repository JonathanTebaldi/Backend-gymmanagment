package br.edu.fema.tccacademia.models.pessoa;


import br.edu.fema.tccacademia.enums.SexoEnum;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
public class Pessoa {
    private UUID id;
    private String nome;
    private SexoEnum sexo;
    private String celular;
    private String CPF;
    private LocalDateTime dataNascimento;
    private String rg;
    private String endereco;
    private String bairro;



}
