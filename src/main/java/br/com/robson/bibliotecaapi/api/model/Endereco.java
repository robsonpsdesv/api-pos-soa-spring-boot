package br.com.robson.bibliotecaapi.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo rua é obrigatório.")
    private String rua;

    @NotBlank(message = "O campo bairro é obrigatório.")
    private String bairro;

    @NotBlank(message = "O campo quadra é obrigatório.")
    private String quadra;

    @NotBlank(message = "O campo lote é obrigatório.")
    private String lote;

    @NotBlank(message = "O campo número é obrigatório.")
    private String numero;

    @NotBlank(message = "O campo complemento é obrigatório.")
    private String complemento;

    @NotBlank(message = "O campo cidade é obrigatório.")
    private String cidade;

    @NotBlank(message = "O campo estado é obrigatório.")
    private String estado;

    @NotBlank(message = "O campo país é obrigatório.")
    private String pais;

}
