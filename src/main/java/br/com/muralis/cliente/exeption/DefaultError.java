package br.com.muralis.cliente.exeption;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DefaultError {

    private String msg;
    private HttpStatus httpStatus;
}
