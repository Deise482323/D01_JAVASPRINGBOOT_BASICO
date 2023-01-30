package br.com.muralis.cliente.service;

import br.com.muralis.cliente.entity.Cliente;
import br.com.muralis.cliente.entity.Contato;
import br.com.muralis.cliente.http.domain.request.ClienteSalvarRequest;
import br.com.muralis.cliente.http.domain.request.ContatoRequest;
import br.com.muralis.cliente.http.mapper.ClienteSaveRequestMappper;
import br.com.muralis.cliente.repository.ClienteRepository;
import br.com.muralis.cliente.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalvarCliente {

    @Autowired
    private ClienteRepository repository;
    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private ClienteSaveRequestMappper clienteSaveRequestMappper;

    public void salvar(ClienteSalvarRequest request) {

        Cliente cliente = repository.save(clienteSaveRequestMappper.mapper(request));

        for (ContatoRequest c : request.getContatos()) {
            contatoRepository
                    .save(Contato
                            .builder()
                            .cliente(cliente)
                            .texto(c.getTexto())
                            .tipo(c.getTipoContato())
                            .build()
                    );
        }
    }
}