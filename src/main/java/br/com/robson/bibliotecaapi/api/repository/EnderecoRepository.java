package br.com.robson.bibliotecaapi.api.repository;

import br.com.robson.bibliotecaapi.api.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
