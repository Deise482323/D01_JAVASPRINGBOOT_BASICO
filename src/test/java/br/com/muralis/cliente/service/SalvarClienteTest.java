package br.com.muralis.cliente.service;

import br.com.muralis.cliente.entity.Cliente;
import br.com.muralis.cliente.entity.Contato;
import br.com.muralis.cliente.http.domain.enuns.TipoContato;
import br.com.muralis.cliente.http.domain.request.ClienteSalvarRequest;
import br.com.muralis.cliente.http.domain.request.ContatoRequest;
import br.com.muralis.cliente.http.mapper.ClienteSaveRequestMappper;
import br.com.muralis.cliente.repository.ClienteRepository;
import br.com.muralis.cliente.repository.ContatoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SalvarClienteTest {

    @InjectMocks
    private SalvarCliente target;
    @Mock
    private ClienteRepository repository;
    @Mock
    private ContatoRepository contatoRepository;
    @Mock
    private ClienteSaveRequestMappper clienteSaveRequestMappper;

    @Test
    public void salvarClienteQuandoEntityNotNullTest() {

        ClienteSalvarRequest request = new ClienteSalvarRequest("Deise Santana", List.of(new ContatoRequest(TipoContato.EMAIL, "teste@gmail.com")));
        Cliente cliente = new Cliente(1L, "Deise Santana", LocalDateTime.now(), List.of());
        Contato contato = new Contato(1L, TipoContato.EMAIL, "deise0509@gmail.com", cliente);

        when(clienteSaveRequestMappper.mapper(request)).thenReturn(cliente);
        when(repository.save(cliente)).thenReturn(cliente);
        target.salvar(request);

        verify(repository, times(1)).save(cliente);
        verify(clienteSaveRequestMappper, times(1)).mapper(request);
    }
}