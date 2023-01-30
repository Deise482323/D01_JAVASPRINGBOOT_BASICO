package br.com.muralis.cliente.config;

import br.com.muralis.cliente.exeption.ClienteNaoEncontradoException;
import br.com.muralis.cliente.exeption.ContatoNaoEncontradoException;
import br.com.muralis.cliente.exeption.DefaultError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.status;

@Slf4j
@RestController
@ControllerAdvice
public class HandlerConfig {

    @ExceptionHandler(value = ClienteNaoEncontradoException.class)
    public ResponseEntity<DefaultError> clienteNaoEncontradoException() {
        return
                status(HttpStatus.NOT_FOUND)
                        .body(
                                DefaultError
                                        .builder()
                                        .msg("Cliente Não Encontrado")
                                        .httpStatus(HttpStatus.NOT_FOUND)
                                        .build()
                        );
    }

    @ExceptionHandler(value = ContatoNaoEncontradoException.class)
    public ResponseEntity<DefaultError> contatoNaoEncontradoException() {
        return
                status(HttpStatus.NOT_FOUND)
                        .body(
                                DefaultError
                                        .builder()
                                        .msg("Contato Não Encontrado")
                                        .httpStatus(HttpStatus.NOT_FOUND)
                                        .build()
                        );
    }
}
