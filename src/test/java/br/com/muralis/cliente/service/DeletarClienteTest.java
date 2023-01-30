package br.com.muralis.cliente.service;

import br.com.muralis.cliente.exeption.ClienteNaoEncontradoException;
import br.com.muralis.cliente.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.EmptyResultDataAccessException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DeletarClienteTest {

    @InjectMocks
    private DeletarCliente target;

    @Mock
    private ClienteRepository repository;

    @Test
    public void deletarClienteQuandoEntityNotNullTest() {
        Long id = 1L;

        target.deletar(id);

        verify(repository, times(1)).deleteById(id);
    }

    @Test
    public void deletarClienteQuandoEntityNullTest() {
        Long id = 1L;

        doThrow(EmptyResultDataAccessException.class).when(repository)
                .deleteById(id);
        assertThrows(ClienteNaoEncontradoException.class, () -> target.deletar(id));
    }
}