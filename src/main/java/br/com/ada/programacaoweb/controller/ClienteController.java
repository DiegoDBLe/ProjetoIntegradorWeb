package br.com.ada.programacaoweb.controller;

import br.com.ada.programacaoweb.model.Cliente;
import br.com.ada.programacaoweb.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }

    @PostMapping
    public void incluir(@RequestBody Cliente cliente){
        clienteRepository.save(cliente);
    }

    @PutMapping
    public void alterar(@RequestBody Cliente cliente){
        clienteRepository.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void deleltarPorId(@PathVariable Long id){
        clienteRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<Cliente> listarCliete(@PathVariable Long id){
        return clienteRepository.findById(id);
    }
}
