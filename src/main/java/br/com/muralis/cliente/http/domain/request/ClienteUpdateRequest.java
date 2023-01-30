package br.com.muralis.cliente.http.domain.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteUpdateRequest {

    @NotNull(message = "Nome não pode ser nulo")
    private String nome;
}
