package br.com.muralis.cliente.service;

import br.com.muralis.cliente.exeption.ClienteNaoEncontradoException;
import br.com.muralis.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class DeletarCliente {

    @Autowired
    private ClienteRepository repository;

    public void deletar(Long id) {

        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ClienteNaoEncontradoException();
        }
    }
}
