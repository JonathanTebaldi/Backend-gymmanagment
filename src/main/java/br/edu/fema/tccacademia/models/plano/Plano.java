package br.edu.fema.tccacademia.models.plano;

import br.edu.fema.tccacademia.models.modalidade.Modalidade;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Plano {
    private UUID id;
    private String descricao;
    private float preco;
    private List<Modalidade> modalidades;


}
