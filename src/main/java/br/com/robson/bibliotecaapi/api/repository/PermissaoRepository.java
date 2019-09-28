package br.com.robson.bibliotecaapi.api.repository;

import br.com.robson.bibliotecaapi.api.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

}
