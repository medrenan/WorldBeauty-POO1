package br.com.worldbeauty.controller;

import br.com.worldbeauty.model.Cliente;
import br.com.worldbeauty.service.impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CadastroController {
    @Autowired
    public ClienteServiceImpl clienteServiceImpl;

    @GetMapping("/cliente/cadastrar")
    public String paginaCadastro() {
        return "cadastrar";
    }

    @PostMapping("/cliente/cadastrar")
    public String paginaCadastro(Cliente cliente) {
        clienteServiceImpl.criar(cliente);
        return "cadastrar";
    }
}
