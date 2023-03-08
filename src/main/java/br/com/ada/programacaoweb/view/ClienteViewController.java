package br.com.ada.programacaoweb.view;

import br.com.ada.programacaoweb.controller.ClienteController;
import br.com.ada.programacaoweb.dto.ClienteRequest;
import br.com.ada.programacaoweb.dto.ClienteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class ClienteViewController {

    private final ClienteController clienteController;

    @RequestMapping(value = {"","/","/cliente"})
    public String exibiTelaInicio(Model model){
        model.addAttribute("clientes");
        return "inicio";
    }

    @RequestMapping(value = "/clientes")
    public String exibiTodosOsClientes(Model model){
        model.addAttribute("clientes", clienteController.readAll());
        return "cliente-list";
    }

    @GetMapping("/cliente-new")
    public String exibiCadastroCliente(Model model, ClienteResponse clienteResponse){
        model.addAttribute("cliente", clienteResponse);
        return "cliente-create";
    }

    @GetMapping("/cliente-edit/{id}")
    public String exibiEditarCliente(@PathVariable("id") String id, Model model){
        ClienteResponse clienteResponse = clienteController.read(id);
        model.addAttribute("cliente", clienteResponse);
        return "cliente-update";
    }

    @GetMapping("/cliente-delete/{id}")
    public String exibiDeleteCliente(@PathVariable("id") String id, Model model){
        ClienteResponse clienteResponse = clienteController.read(id);
        model.addAttribute("cliente", clienteResponse);
        return "cliente-excluir";
    }

    @PostMapping("/excluir/{id}")
    public String deleteCliente(@PathVariable("id") String id){
        clienteController.delete(id);
        return "redirect:/inicio";
    }

    @PostMapping("/cliente-add")
    public String addCliente(ClienteResponse clienteResponse, BindingResult result, Model model){
        if(result.hasErrors()){
            return "cliente-create";
        }

        ClienteRequest clienteRequest = new ClienteRequest();
        BeanUtils.copyProperties(clienteResponse, clienteRequest);
        clienteController.create(clienteRequest);
        return "redirect:/clientes";
    }

    @PostMapping("/cliente-save/{id}")
    public String updateCliente(@PathVariable("id") String id, ClienteResponse clienteResponse,
                                BindingResult result, Model model){
        if(result.hasErrors()){
            clienteResponse.setId(id);
            return "cliente-update";
        }

        ClienteRequest clienteRequest = new ClienteRequest();
        BeanUtils.copyProperties(clienteResponse, clienteRequest);

        clienteController.update(clienteResponse.getId(), clienteRequest);
        return "redirect:/clientes";
    }
}
