package br.edu.fema.tccacademia.models.endereco;

import jakarta.validation.constraints.NotBlank;

public record DadosEndereco(
        @NotBlank
        String bairro,
        @NotBlank
        String numero,
        @NotBlank
        String cidade,
        @NotBlank
        String uf
) {
}
