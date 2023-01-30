package br.com.muralis.cliente.service;

import br.com.muralis.cliente.entity.Cliente;
import br.com.muralis.cliente.http.domain.response.ClienteResponse;
import br.com.muralis.cliente.http.mapper.ClienteResponseMapper;
import br.com.muralis.cliente.repository.ClienteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ListarClienteTest {

    @InjectMocks
    private ListarCliente target;

    @Mock
    private ClienteRepository repository;

    @Mock
    private ClienteResponseMapper mapper;


    @Test
    public void listarClienteQuandoEntityNotNullTest() {

        List<Cliente> clientes = new ArrayList<>();
        List<ClienteResponse> clienteResponse = new ArrayList<>();
        clienteResponse.add(new ClienteResponse("Deise", LocalDateTime.now(), List.of()));
        clientes.add(new Cliente(1L, "Deise", LocalDateTime.now(), List.of()));

        when(repository.findAll()).thenReturn(clientes);
        when(mapper.mapper(clientes)).thenReturn(clienteResponse);
        List<ClienteResponse> response = target.listarTodos();

        verify(repository, times(1)).findAll();
        verify(mapper, times(1)).mapper(clientes);
        Assertions.assertEquals(clienteResponse, response);
    }
}