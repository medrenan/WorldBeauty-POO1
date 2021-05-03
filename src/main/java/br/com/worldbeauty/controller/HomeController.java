package br.com.worldbeauty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String paginaHome() {
        return "index";
    }

    @GetMapping("/sobre")
    public String paginaSobre() {
        return "sobre";
    }

    @GetMapping("/contato")
    public String paginaContato() {
        return "contato";
    }

}
