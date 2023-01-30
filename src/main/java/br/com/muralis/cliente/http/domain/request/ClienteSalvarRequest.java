package br.com.muralis.cliente.http.domain.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteSalvarRequest {

    @NotNull(message = "Nome não pode ser nulo")
    private String nome;
    private List<ContatoRequest> contatos;
}
