package br.com.robson.bibliotecaapi.api.service;

import br.com.robson.bibliotecaapi.api.model.Emprestimo;
import br.com.robson.bibliotecaapi.api.repository.EmprestimoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Transactional
    public Emprestimo inserir(Emprestimo emprestimo){

        emprestimo.setId (null);
        return emprestimoRepository.save (emprestimo);

    }

    public Emprestimo pesquisarPorId(Long id){

        return emprestimoRepository.findById (id).orElseThrow (()-> new EmptyResultDataAccessException (1));

    }

    @Transactional
    public Emprestimo alterar(Emprestimo emprestimo, Long id){

        Emprestimo emprestimoPesquisado = pesquisarPorId (id);

        BeanUtils.copyProperties (emprestimo, emprestimoPesquisado, "id");

        return emprestimoRepository.save (emprestimoPesquisado);

    }

    @Transactional
    public void excluir(Long id){

        emprestimoRepository.deleteById (id);

    }

    public List<Emprestimo> listar(){

        return emprestimoRepository.findAll ();

    }

}
