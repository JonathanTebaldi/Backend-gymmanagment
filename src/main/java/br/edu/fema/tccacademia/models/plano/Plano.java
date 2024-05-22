package br.edu.fema.tccacademia.models.plano;

import br.edu.fema.tccacademia.models.modalidade.Modalidade;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity(name = "Plano")
@Table(name = "planos")
@Getter
@Setter
public class Plano {
    @Id
    private UUID id;
    private String nome;
    private String descricao;
    private Double preco;
    @OneToMany
    private List<Modalidade> modalidades;

    public Plano(DadosCadastroPlano dados) {
        this.id = UUID.randomUUID();
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.preco = dados.preco();
        this.modalidades = dados.modalidades();
    }

    public void atualizarInformacoes(DadosAtualizacaoPlano dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.descricao() != null){
            this.descricao = dados.descricao();
        }
        if(dados.preco() != null){
            this.preco = dados.preco();
        }
        if(dados.modalidades() != null){
            this.modalidades = dados.modalidades();
        }
    }

    public void excluir() {
    }
}
