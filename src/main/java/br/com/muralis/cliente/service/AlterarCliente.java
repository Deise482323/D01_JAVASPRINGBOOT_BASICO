package br.com.muralis.cliente.service;

import br.com.muralis.cliente.entity.Cliente;
import br.com.muralis.cliente.exeption.ClienteNaoEncontradoException;
import br.com.muralis.cliente.http.domain.request.ClienteUpdateRequest;
import br.com.muralis.cliente.repository.ClienteRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlterarCliente {

    @Autowired
    private ClienteRepository repository;

    @SneakyThrows
    public void alterar(Long id, ClienteUpdateRequest request) {

        Optional<Cliente> entity = repository.findById(id);
        if (entity.isPresent()) {
            Cliente objetoPersistencia = entity.get();
            objetoPersistencia.setNome(request.getNome());
            repository.save(objetoPersistencia);
        } else {
            throw new ClienteNaoEncontradoException();
        }
    }
}
