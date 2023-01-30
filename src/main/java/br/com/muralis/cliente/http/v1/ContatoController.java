package br.com.muralis.cliente.http.v1;

import br.com.muralis.cliente.http.domain.request.ContatoRequest;
import br.com.muralis.cliente.service.AlterarContatoService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/contato")
@Api(tags = "Contato", produces = APPLICATION_JSON_VALUE)
@CrossOrigin
@RequiredArgsConstructor
public class ContatoController {

    private final AlterarContatoService alterarContatoService;

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void alterar(@RequestParam("id") Long id, @RequestBody ContatoRequest request) {
        alterarContatoService.alterar(id, request);
    }
}
