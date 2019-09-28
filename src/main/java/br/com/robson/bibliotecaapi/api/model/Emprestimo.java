package br.com.robson.bibliotecaapi.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O campo data do empréstimo é obrigatório.")
    private LocalDate dataDoEmprestimo;

    @NotNull(message = "O campo data da devolução é obrigatorio.")
    private LocalDate dataDaDevolucao;

    @NotNull(message = "O campo valor do empréstimo é obrigatorio.")
    private BigDecimal valorDoEmprestimo;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @NotNull(message = "O campo cliente é obrigatorio.")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_livro")
    @NotNull(message = "O campo livro é obrigatorio.")
    private Livro livro;

}
