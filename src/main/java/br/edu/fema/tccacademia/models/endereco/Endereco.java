package br.edu.fema.tccacademia.models.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String bairro;
    private String numero;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco dados){
        this.bairro = dados.bairro();
        this.numero = dados.numero();
        this.uf = dados.uf();
        this.cidade = dados.cidade();
    }

    public void atualizarInformacoes(DadosEndereco dados){
        if(dados.bairro() != null){
            this.bairro = dados.bairro();
        }
        if(dados.numero() != null){
            this.numero = dados.numero();
        }
        if(dados.uf() != null){
            this.uf = dados.uf();
        }
        if(dados.cidade() != null){
            this.cidade = dados.cidade();
        }
    }
}
