package br.com.robson.bibliotecaapi.api.model;

import br.com.robson.bibliotecaapi.api.model.type.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Autor nome obrigatorio")
    private String nome;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O campo sexo é obrigatorio.")
    private Sexo sexo;

}
