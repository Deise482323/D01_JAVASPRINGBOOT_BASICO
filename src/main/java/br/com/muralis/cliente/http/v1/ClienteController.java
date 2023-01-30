package br.com.muralis.cliente.http.v1;

import br.com.muralis.cliente.http.domain.request.ClienteSalvarRequest;
import br.com.muralis.cliente.http.domain.request.ClienteUpdateRequest;
import br.com.muralis.cliente.http.domain.response.ClienteResponse;
import br.com.muralis.cliente.service.*;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/cliente")
@Api(tags = "Cliente", produces = APPLICATION_JSON_VALUE)
@CrossOrigin
@RequiredArgsConstructor
public class ClienteController {

    private final SalvarCliente salvarCliente;
    private final ListarCliente ListarCliente;
    private final DeletarCliente deletarCliente;
    private final AlterarCliente alterarCliente;
    private final ConsultarCLiente consultarCLiente;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody ClienteSalvarRequest request) {
        salvarCliente.salvar(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteResponse> listarTodos() {
        return ListarCliente.listarTodos();
    }

    @GetMapping("/por-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteResponse consultarPorId(@RequestParam("id") Long id) {
        return consultarCLiente.consultarPorId(id);
    }

    @DeleteMapping("/por-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(Long id) {
        deletarCliente.deletar(id);
    }

    @PutMapping("/update-por-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void alterar(@RequestParam("id") Long id, @RequestBody ClienteUpdateRequest request) {
        alterarCliente.alterar(id, request);
    }
}
