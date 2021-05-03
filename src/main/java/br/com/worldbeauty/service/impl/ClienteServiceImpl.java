package br.com.worldbeauty.service.impl;

import br.com.worldbeauty.model.Cliente;
import br.com.worldbeauty.service.ClienteService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
@Transactional
public class ClienteServiceImpl implements ClienteService {

    @PersistenceContext
    private EntityManager em;


    @Override
    public void criar(Cliente cliente) {
        this.em.persist(cliente);
    }

    @Override
    public void remover(Cliente cliente) {
        Cliente connectedEntity = this.recuperar(cliente.getId());

        if (connectedEntity == null ) {
            return;
        }

        this.em.remove(connectedEntity);
    }

    @Override
    public Cliente editar(Cliente cliente) {
        return this.em.merge(cliente);
    }

    @Transactional(readOnly = true)
    public Cliente recuperar(Long id) {
        return this.em.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> buscarTodos() {
        String queryString = "SELECT c FROM Cliente c ORDER BY c.id";
        Query query = this.em.createQuery(queryString);
        List<Cliente> list = query.getResultList();

        return list;
    }
}
