package br.edu.fema.tccacademia.models.plano;

import br.edu.fema.tccacademia.models.modalidade.Modalidade;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.UUID;

public record DadosAtualizacaoPlano(
        @NotBlank
        UUID id,
        String nome,
        String descricao,
        Double preco,
        List<Modalidade> modalidades
) {
}
