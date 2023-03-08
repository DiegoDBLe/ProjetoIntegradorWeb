package br.com.ada.programacaoweb.repository;

import br.com.ada.programacaoweb.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, String> {
}
