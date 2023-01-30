package br.com.muralis.cliente.http.domain.response;

import br.com.muralis.cliente.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {

    private String nome;
    private LocalDateTime dataCadastro;
    private List<ContatoResponse> contatos;

    public ClienteResponse(Cliente cliente) {
        this.nome = cliente.getNome();
        this.dataCadastro = cliente.getDataCadastro();
        this.contatos = cliente.getContatos().stream().map(ContatoResponse::new).collect(Collectors.toList());
    }
}
