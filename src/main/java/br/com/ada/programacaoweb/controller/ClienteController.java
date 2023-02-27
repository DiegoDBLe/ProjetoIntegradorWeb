package br.com.ada.programacaoweb.controller;

import br.com.ada.programacaoweb.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @GetMapping
    public Cliente getInformacao(){

        Cliente cliente = new Cliente(1L, "Cliente", "85-9999-9999", "cliente@gmail.com", Instant.now());
        return cliente;
    }
}
