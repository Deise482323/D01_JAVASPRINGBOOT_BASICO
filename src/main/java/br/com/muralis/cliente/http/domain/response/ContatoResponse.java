package br.com.muralis.cliente.http.domain.response;

import br.com.muralis.cliente.entity.Contato;
import br.com.muralis.cliente.http.domain.enuns.TipoContato;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContatoResponse {

    private TipoContato tipoContato;
    private String texto;

    public ContatoResponse(Contato contato) {
        this.tipoContato = contato.getTipo();
        this.texto = contato.getTexto();
    }
}
