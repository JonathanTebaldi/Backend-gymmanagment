package br.edu.fema.tccacademia.enums;

public enum SexoEnum {
    MASCULINO("Masculino"),
    FEMININO("Feminino");

    private final String descricao;

    SexoEnum(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
