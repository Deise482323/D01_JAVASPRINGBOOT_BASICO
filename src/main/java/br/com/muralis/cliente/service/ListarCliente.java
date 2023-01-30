package br.com.muralis.cliente.service;

import br.com.muralis.cliente.http.domain.response.ClienteResponse;
import br.com.muralis.cliente.http.mapper.ClienteResponseMapper;
import br.com.muralis.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarCliente {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteResponseMapper mapper;

    public List<ClienteResponse> listarTodos() {
        return mapper.mapper(repository.findAll());
    }
}


