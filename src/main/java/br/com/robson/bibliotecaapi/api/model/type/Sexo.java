package br.com.robson.bibliotecaapi.api.model.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Sexo {

    MASCULINO("MASCULINO"),
    FEMININO("FEMININO");

    @Getter
    private String sexo;
}
