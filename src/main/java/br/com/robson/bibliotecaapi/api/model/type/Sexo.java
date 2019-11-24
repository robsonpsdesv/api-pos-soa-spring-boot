package br.com.robson.bibliotecaapi.api.model.type;

public enum Sexo {

    MASCULINO("MASCULINO"),
    FEMININO("FEMININO");

    private String descricao;

    Sexo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
