package br.com.ada.programacaoweb.service;

import br.com.ada.programacaoweb.model.Cliente;
import br.com.ada.programacaoweb.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente criar(Cliente cliente){
        if(cliente.getId() != null){
            throw new IllegalArgumentException();
        }
        cliente.setId(UUID.randomUUID().toString());
        cliente.setDataCadastro(Instant.now());
        return clienteRepository.save(cliente);
    }

    public Cliente obter(String id){
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> obterTodos(){
        List<Cliente> lista = new ArrayList<>();
        clienteRepository.findAll().forEach(cliente -> lista.add(cliente));
        return lista;
    }

    public Cliente atualizar(Cliente cliente){
        cliente.setDataCadastro(Instant.now());
        return clienteRepository.save(cliente);
    }

    public  Cliente delete(String id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
        clienteRepository.delete(cliente);
        return cliente;
    }
}
