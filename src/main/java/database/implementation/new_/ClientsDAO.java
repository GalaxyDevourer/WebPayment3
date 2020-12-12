package database.implementation.new_;

import database.interfaces.FactoryCRUD;
import models.entities.new_.ClientsEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ClientsDAO extends FactoryCRUD<ClientsEntity> {
    @PersistenceContext(name = "chmnu.persistence")
    EntityManager em;

    public ClientsDAO () {
    }

    @Override
    public ClientsEntity getById(Integer id) {
        return em.find(ClientsEntity.class, id);
    }

    @Override
    public List<ClientsEntity> select() {
        return em.createQuery("select c from ClientsEntity c").getResultList();
        // em.createNamedQuery("Clients.select", ClientsEntity.class).getResultList();
    }

    @Override
    public void insert(ClientsEntity client) {
        em.persist(client);
    }

    @Override
    public void update(ClientsEntity client) {
        if (client.getName()!=null){
            Query query = em.createQuery("update ClientsEntity c SET c.name = :name WHERE c.id = :id");
            query.setParameter("name", client.getName());
            query.setParameter("id", client.getId());
            query.executeUpdate();
            em.createNamedQuery("Clients.select", ClientsEntity.class).getResultList();
        }
    }

    @Override
    public void delete(ClientsEntity client) {
        Query query = em.createQuery("DELETE FROM ClientsEntity c WHERE c.id = :id");
        query.setParameter("id", client.getId());
        query.executeUpdate();
        em.createNamedQuery("Clients.select", ClientsEntity.class).getResultList();
    }
}
