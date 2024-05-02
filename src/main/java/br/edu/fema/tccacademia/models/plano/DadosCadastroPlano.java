package br.edu.fema.tccacademia.models.plano;

import br.edu.fema.tccacademia.models.modalidade.Modalidade;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record DadosCadastroPlano(
        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        Double preco,
        List<Modalidade>  modalidades
) {
}
