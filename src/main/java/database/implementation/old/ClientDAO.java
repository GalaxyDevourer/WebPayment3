package database.implementation.old;

import database.interfaces.FactoryCRUD;
import models.entities.old.Client;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ClientDAO extends FactoryCRUD<Client> {
    @PersistenceContext(name = "chmnu.persistence")
    EntityManager em;

    public ClientDAO () {
    }

    @Override
    public Client getById(Integer id) {
        return em.find(Client.class, id);
    }

    @Override
    public List<Client> select() {
        return em.createNamedQuery("Client.select", Client.class).getResultList();
    }

    @Override
    public void insert(Client client) {
        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();
    }

    @Override
    public void update(Client client) {
        insert(client);
    }

    @Override
    public void delete(Client client) {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Client c WHERE c.id = " + client.getId()).executeUpdate();
        em.getTransaction().commit();
    }

    public List<String> getClientsNames() {
        return em.createQuery("SELECT c.name FROM Client c", String.class).getResultList();
    }

    public List<String> getClientsIdByName(String name) {
        return em.createQuery("SELECT c.id FROM Client c WHERE c.name = " + name, String.class).getResultList();
    }
}
