package br.com.muralis.cliente.service;

import br.com.muralis.cliente.entity.Cliente;
import br.com.muralis.cliente.exeption.ClienteNaoEncontradoException;
import br.com.muralis.cliente.http.domain.response.ClienteResponse;
import br.com.muralis.cliente.repository.ClienteRepository;
import org.junit.jupiter.api.Assertions;
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
public class ConsultarCLienteTest {

    @InjectMocks
    private ConsultarCLiente target;

    @Mock
    private ClienteRepository repository;

    @Test
    public void consultarClienteQuandoEntityNotNullTest() {

        Long id = 1L;

        ClienteResponse response = new ClienteResponse("Deise Santana", LocalDateTime.now(), List.of());

        Cliente cliente = new Cliente(1L, "Deise Santana", LocalDateTime.now(), List.of());
        Optional<Cliente> entity = Optional.of(cliente);

        when(repository.findById(id)).thenReturn(entity);
        ClienteResponse retorno = target.consultarPorId(id);

        verify(repository, times(1)).findById(id);
        Assertions.assertEquals("Deise Santana", retorno.getNome());

    }

    @Test
    public void consultarClienteQuandoEntityNullTest() {

        Long id = 1L;
        ClienteResponse response = new ClienteResponse("Deise Santana", LocalDateTime.now(), List.of());
        Optional<Cliente> entity = Optional.empty();

        when(repository.findById(id)).thenReturn(entity);

        assertThrows(ClienteNaoEncontradoException.class, () ->
                target.consultarPorId(id)
        );

        verify(repository, times(1)).findById(id);
    }
}