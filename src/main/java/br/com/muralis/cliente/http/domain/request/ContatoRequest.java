package br.com.muralis.cliente.http.domain.request;

import br.com.muralis.cliente.http.domain.enuns.TipoContato;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContatoRequest {

    @NotNull(message = "Tipo de contato não pode ser nulo")
    private TipoContato tipoContato;
    @Size(min = 10, max = 200, message = "Texto deve ter entre 10 e 200 caracteres")
    private String texto;
}
