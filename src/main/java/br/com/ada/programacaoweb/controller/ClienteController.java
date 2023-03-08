package br.com.ada.programacaoweb.controller;

import br.com.ada.programacaoweb.dto.ClienteRequest;
import br.com.ada.programacaoweb.dto.ClienteResponse;
import br.com.ada.programacaoweb.model.Cliente;
import br.com.ada.programacaoweb.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("inicio")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public String create(@RequestBody ClienteRequest clienteRequest){
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteRequest, cliente);
        cliente = clienteService.criar(cliente);
        return cliente.getId();
    }

    @GetMapping
    public List<ClienteResponse> readAll(){
        return clienteService.obterTodos().stream().map(cliente -> {
            ClienteResponse clienteResponse = new ClienteResponse();
            BeanUtils.copyProperties(cliente, clienteResponse);
            return clienteResponse;
        }).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public ClienteResponse read(@PathVariable String id){
        Cliente cliente = clienteService.obter(id);
        ClienteResponse clienteResponse = new ClienteResponse();
        BeanUtils.copyProperties(cliente, clienteResponse);
        return clienteResponse;
        }


    @PutMapping("{id}")
    public ClienteResponse update(@PathVariable String id, @RequestBody ClienteRequest clienteRequest){
        Cliente cliente = clienteService.obter(id);
        BeanUtils.copyProperties(clienteRequest, cliente);
        cliente = clienteService.atualizar(cliente);
        ClienteResponse clienteResponse = new ClienteResponse();
        BeanUtils.copyProperties(cliente, clienteResponse);
        return clienteResponse;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id)
    {
        clienteService.delete(id);
    }
}
