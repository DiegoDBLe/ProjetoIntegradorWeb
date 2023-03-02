package br.com.ada.programacaoweb.bean;

import br.com.ada.programacaoweb.model.Cliente;
import br.com.ada.programacaoweb.repository.ClienteRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named(value = "clienteBean")
@ViewScoped
public class ClienteBean {

    @Getter
    @Setter
    private List<Cliente> clientes = new ArrayList<>();

    @Getter
    @Setter
    private Cliente cliente;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos() {
        clientes = clienteRepository.findAll();
        return clientes;
    }

    @PostConstruct
    public Integer getTamanhoDaLista(){
        return clientes.size();
    }

    public void setTamanhoDaLista(Integer size) {
        // Método criado para ser utilizado pelo primefaces
    }
}
