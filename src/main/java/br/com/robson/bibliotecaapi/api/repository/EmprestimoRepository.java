package br.com.robson.bibliotecaapi.api.repository;

import br.com.robson.bibliotecaapi.api.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}
