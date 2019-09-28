package br.com.robson.bibliotecaapi.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo nome é obrigatório.")
    private String nome;

    @NotNull(message = "O campo volume é obrigatório.")
    private Integer volume;

    @NotNull(message = "O campo data de publicação é obrigatório.")
    private LocalDate dataPublicacao;

    @NotNull(message = "O campo valor é obrigatório.")
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "id_genero")
    @NotNull(message = "O campo gênero é obrigatório.")
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "id_editora")
    @NotNull(message = "O campo editora é obrigatório.")
    private Editora editora;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    @NotNull(message = "O campo autor é obrigatório.")
    private Autor autor;
}
