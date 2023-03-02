package br.com.ada.programacaoweb.data;

import br.com.ada.programacaoweb.model.Cliente;
import br.com.ada.programacaoweb.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Instant;

@Component
public class CarregaData {

    @Value("${habilitar.carregar.massa.dados}")
    private boolean podeCarregarDados;

    @Autowired
    private ClienteRepository clienteRepository;

    @PostConstruct
    public void loadData(){
        if(podeCarregarDados){
            for (int x = 0; x < 50; x++){
                clienteRepository.save(new Cliente((long) x,"Jose da Silva" + x, "99662-554" + x, "jose@feltex.com.br", Instant.now()));
            }
        }
    }
}
