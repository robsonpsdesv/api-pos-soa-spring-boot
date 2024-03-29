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
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo nome é obrigatorio.")
    private String nome;

    @NotBlank(message = "O campo CPF é obrigatorio.")
    private String cpf;

    @NotBlank(message = "O campo e-mail é obrigatorio.")
    private String email;

    @NotBlank(message = "O campo telefone é obrigatorio.")
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    @NotNull(message = "O campo endereço é obrigatorio.")
    private Endereco endereco;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O campo sexo é obrigatorio.")
    private Sexo sexo;

}
