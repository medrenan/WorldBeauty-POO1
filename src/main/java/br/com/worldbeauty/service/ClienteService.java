package br.com.worldbeauty.service;

import br.com.worldbeauty.model.Cliente;

import java.util.List;

public interface ClienteService {

    void criar(Cliente cliente);

    void remover(Cliente cliente);

    Cliente editar(Cliente cliente);

    List<Cliente> buscarTodos();
}
