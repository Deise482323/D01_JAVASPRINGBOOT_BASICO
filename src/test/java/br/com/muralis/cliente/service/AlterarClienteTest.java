package br.com.muralis.cliente.service;

import br.com.muralis.cliente.entity.Cliente;
import br.com.muralis.cliente.exeption.ClienteNaoEncontradoException;
import br.com.muralis.cliente.http.domain.request.ClienteUpdateRequest;
import br.com.muralis.cliente.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AlterarClienteTest {

    @InjectMocks
    private AlterarCliente target;

    @Mock
    private ClienteRepository repository;

    @Test
    public void alterarClienteQuandoEntityNotNullTest() {

        Long id = 1L;
        ClienteUpdateRequest request = new ClienteUpdateRequest("Deise Santana");
        Cliente cliente = new Cliente(1L, "Deise", LocalDateTime.now(), List.of());
        Optional<Cliente> entity = Optional.of(cliente);

        when(repository.findById(id)).thenReturn(entity);
        target.alterar(id, request);

        verify(repository, times(1)).findById(id);
        verify(repository, times(1)).save(cliente);

    }

    @Test
    public void alterarClienteQuandoEntityNullTest() {

        Long id = 1L;
        ClienteUpdateRequest request = new ClienteUpdateRequest("Deise Santana");
        Optional<Cliente> entity = Optional.empty();

        when(repository.findById(id)).thenReturn(entity);

        assertThrows(ClienteNaoEncontradoException.class, () ->
                target.alterar(id, request)
        );

        verify(repository, times(1)).findById(id);
    }
}
