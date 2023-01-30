package br.com.muralis.cliente.http.mapper;

import br.com.muralis.cliente.entity.Cliente;
import br.com.muralis.cliente.http.domain.request.ClienteSalvarRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ClienteSaveRequestMappper {

    public Cliente mapper(ClienteSalvarRequest request) {
        return Cliente
                .builder()
                .dataCadastro(LocalDateTime.now())
                .nome(request.getNome())
                .build();
    }
}