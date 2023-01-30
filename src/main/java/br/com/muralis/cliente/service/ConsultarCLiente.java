package br.com.muralis.cliente.service;

import br.com.muralis.cliente.entity.Cliente;
import br.com.muralis.cliente.exeption.ClienteNaoEncontradoException;
import br.com.muralis.cliente.http.domain.response.ClienteResponse;
import br.com.muralis.cliente.repository.ClienteRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsultarCLiente {

    @Autowired
    private ClienteRepository repository;

    @SneakyThrows
    public ClienteResponse consultarPorId(Long id) {

        Optional<Cliente> entity = repository.findById(id);

        if (entity.isPresent()) {
            return new ClienteResponse(entity.get());
        } else {
            throw new ClienteNaoEncontradoException();
        }
    }
}
