package br.com.muralis.cliente.service;

import br.com.muralis.cliente.entity.Cliente;
import br.com.muralis.cliente.entity.Contato;
import br.com.muralis.cliente.exeption.ContatoNaoEncontradoException;
import br.com.muralis.cliente.http.domain.enuns.TipoContato;
import br.com.muralis.cliente.http.domain.request.ContatoRequest;
import br.com.muralis.cliente.repository.ContatoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AlterarContatoServiceTest {

    @InjectMocks
    private AlterarContatoService target;

    @Mock
    private ContatoRepository repository;

    @Test
    public void test() {

        Long id = 1L;
        ContatoRequest request = new ContatoRequest(TipoContato.EMAIL, "deise0509@gmail.com");

        Contato contato = new Contato(1L, TipoContato.TELEFONE, "11966476304", new Cliente());
        Optional<Contato> entity = Optional.of(contato);

        when(repository.findById(id)).thenReturn(entity);
        target.alterar(id, request);

        verify(repository, times(1)).findById(id);
        verify(repository, times(1)).save(contato);

    }
    @Test
    public void alterarContatoQuandoEntityNullTest() {

        Long id = 1L;
        ContatoRequest request = new ContatoRequest(TipoContato.EMAIL, "deise0509@gmail.com");
        Optional<Contato> entity = Optional.empty();

        when(repository.findById(id)).thenReturn(entity);

        assertThrows(ContatoNaoEncontradoException.class, () ->
                target.alterar(id, request)
        );
        verify(repository, times(1)).findById(id);
    }
}