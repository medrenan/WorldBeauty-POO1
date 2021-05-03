package br.com.worldbeauty.controller;

import br.com.worldbeauty.model.Cliente;
import br.com.worldbeauty.service.impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    @GetMapping("/editar/{id}")
    public ModelAndView alterar(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("editar");
        Cliente cliente = clienteServiceImpl.recuperar(id);
        mv.addObject("cliente", cliente);
        return mv;
    }

    @PostMapping("/editar")
    public ModelAndView alterar(Cliente cliente) {
        ModelAndView mv = new ModelAndView();
        clienteServiceImpl.editar(cliente);
        mv.setViewName("redirect:/listar-clientes");
        return mv;
    }

    @GetMapping("/cliente/remover/{id}")
    public String removerCliente(@PathVariable("id") Long id) {
        Cliente cliente = clienteServiceImpl.recuperar(id);
        this.clienteServiceImpl.remover(cliente);
        return "redirect:/cliente/buscar";
    }

}
