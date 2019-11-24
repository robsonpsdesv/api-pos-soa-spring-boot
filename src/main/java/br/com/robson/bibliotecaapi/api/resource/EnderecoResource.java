package br.com.robson.bibliotecaapi.api.resource;

import br.com.robson.bibliotecaapi.api.model.Endereco;
import br.com.robson.bibliotecaapi.api.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoResource {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasAuthority('ROLE_INCLUIR_EMPRESTIMO')")
    public Endereco inserir(@RequestBody @Valid Endereco endereco, HttpServletResponse response){

        Endereco enderecoSalvo = enderecoService.inserir (endereco);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest ()
                .path ("/{id}")
                .buildAndExpand (endereco.getId ()).toUri ();

        response.setHeader (HttpHeaders.LOCATION, uri.toString ());

        return enderecoSalvo;

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
//    @PreAuthorize("hasAuthority('ROLE_LISTAR_EMPRESTIMO')")
    public List<Endereco> listar(){

        return enderecoService.listar ();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
//    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_POR_ID_EMPRESTIMO')")
    public Endereco pesquisarPorId(@PathVariable("id") Long id){

        return enderecoService.pesquisarPorId (id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
//    @PreAuthorize("hasAuthority('ROLE_ALTERAR_EMPRESTIMO')")
    public Endereco alterar(@RequestBody @Valid Endereco endereco, @PathVariable Long id){

        return enderecoService.alterar (endereco, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @PreAuthorize("hasAuthority('ROLE_EXCLUIR_EMPRESTIMO')")
    public void remover(@PathVariable Long id){

        enderecoService.excluir (id);
    }
}
