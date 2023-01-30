package br.com.muralis.cliente.repository;

import br.com.muralis.cliente.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
