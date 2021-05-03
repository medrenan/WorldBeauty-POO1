package br.com.worldbeauty.controller;

import br.com.worldbeauty.model.Cliente;
import br.com.worldbeauty.service.impl.ClienteServiceImpl;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BuscarController {

    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    @GetMapping("/cliente/buscar")
    public ModelAndView buscarClientes() {
        List<Cliente> clientes = clienteServiceImpl.buscarTodos();
        ModelAndView mv = new ModelAndView("listar");
        mv.addObject("clientes", clientes);
        return mv;
    }

    @GetMapping("/cliente/relatorios")
    public String buscarRelatorios() {
        return "relatorios";
    }
}
