package br.com.robson.bibliotecaapi.api.repository;

import br.com.robson.bibliotecaapi.api.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
