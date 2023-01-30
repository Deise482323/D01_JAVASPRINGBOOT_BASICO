package br.com.muralis.cliente.service;

import br.com.muralis.cliente.entity.Contato;
import br.com.muralis.cliente.exeption.ContatoNaoEncontradoException;
import br.com.muralis.cliente.http.domain.request.ContatoRequest;
import br.com.muralis.cliente.repository.ContatoRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlterarContatoService {

    @Autowired
    private ContatoRepository repository;

    @SneakyThrows
    public void alterar(Long id, ContatoRequest request) {

        Optional<Contato> contatoEntity = repository.findById(id);
        if (contatoEntity.isPresent()) {
            Contato contato = contatoEntity.get();
            contato.setTexto(request.getTexto());
            contato.setTipo(request.getTipoContato());
            repository.save(contato);
        } else {
            throw new ContatoNaoEncontradoException();
        }
    }
}
