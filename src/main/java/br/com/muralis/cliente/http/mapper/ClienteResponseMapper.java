package br.com.muralis.cliente.http.mapper;

import br.com.muralis.cliente.entity.Cliente;
import br.com.muralis.cliente.http.domain.response.ClienteResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteResponseMapper {

    public List<ClienteResponse> mapper(List<Cliente> entity) {

        return entity.stream()
                .map(ClienteResponse::new)
                .collect(Collectors.toList());
    }
}
