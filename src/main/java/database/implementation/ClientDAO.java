package database.implementation;

import database.interfaces.FactoryCRUD;
import models.entities.Client;

import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Stateless
public class ClientDAO extends FactoryCRUD<Client> {

    public ClientDAO () {
        EntityManagerFactory ef = Persistence.createEntityManagerFactory("chmnu.persistence");
        em = ef.createEntityManager();
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
    public void checkPersist(Client client) {
        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();
    }

    @Override
    public void update(Client client) {
        checkPersist(client);
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
}
