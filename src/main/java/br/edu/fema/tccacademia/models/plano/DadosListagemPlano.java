package br.edu.fema.tccacademia.models.plano;

import br.edu.fema.tccacademia.models.matricula.Matricula;
import br.edu.fema.tccacademia.models.modalidade.Modalidade;
import jakarta.persistence.OneToMany;

import java.util.List;

public record DadosListagemPlano (
        String nome,
        String descricao,
        Double preco,
        List<Modalidade>modalidades,
        Matricula matricula
){
    public DadosListagemPlano(Plano plano){
        this(plano.getNome(), plano.getDescricao(), plano.getPreco(),
                plano.getModalidades(), plano.getMatricula());
    }
}
