package br.com.robson.bibliotecaapi.api.service;

import br.com.robson.bibliotecaapi.api.model.Cliente;
import br.com.robson.bibliotecaapi.api.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente inserir(Cliente cliente){

        cliente.setId (null);
        return clienteRepository.save (cliente);

    }

    public Cliente pesquisarPorId(Long id){

        return clienteRepository.findById (id).orElseThrow (()-> new EmptyResultDataAccessException (1));

    }

    @Transactional
    public Cliente alterar(Cliente cliente, Long id){

        Cliente clientePesquisado = pesquisarPorId (id);

        BeanUtils.copyProperties (cliente, clientePesquisado, "id");

        return clienteRepository.save (clientePesquisado);

    }

    @Transactional
    public void excluir(Long id){

        clienteRepository.deleteById (id);

    }

    public List<Cliente> listar(){

        return clienteRepository.findAll ();

    }

}
