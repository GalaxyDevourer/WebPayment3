package database.implementation.new_;

import database.interfaces.FactoryCRUD;
import models.entities.new_.ServicesEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ServicesDAO extends FactoryCRUD<ServicesEntity> {
    @PersistenceContext(name = "chmnu.persistence")
    EntityManager em;

    public ServicesDAO () {
    }

    @Override
    public ServicesEntity getById(Integer id) {
        return em.find(ServicesEntity.class, id);
    }

    @Override
    public List<ServicesEntity> select() {
        return em.createQuery("select s from ServicesEntity s").getResultList();
        // em.createNamedQuery("Clients.select", ClientsEntity.class).getResultList();
    }

    @Override
    public void insert(ServicesEntity service) {
        em.persist(service);
    }

    @Override
    public void update(ServicesEntity service) {
        if (service.getTitle()!=null){
            Query query = em.createQuery("update ServicesEntity s SET s.title = :title WHERE s.id = :id");
            query.setParameter("title", service.getTitle());
            query.setParameter("id", service.getId());
            query.executeUpdate();
            em.createNamedQuery("Services.select", ServicesEntity.class).getResultList();
        }
    }

    @Override
    public void delete(ServicesEntity service) {
        Query query = em.createQuery("DELETE FROM ServicesEntity s WHERE s.id = :id");
        query.setParameter("id", service.getId());
        query.executeUpdate();
        em.createNamedQuery("Services.select", ServicesEntity.class).getResultList();
    }
}
