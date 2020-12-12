package database.implementation.old;

import database.interfaces.FactoryCRUD;
import models.entities.old.Service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ServiceDAO extends FactoryCRUD<Service> {
    @PersistenceContext(name = "chmnu.persistence")
    EntityManager em;

    public ServiceDAO () {
    }

    @Override
    public Service getById(Integer id) {
        return em.find(Service.class, id);
    }

    @Override
    public List<Service> select() {
        return em.createNamedQuery("Service.select", Service.class).getResultList();
    }

    @Override
    public void insert(Service service) {
        em.getTransaction().begin();
        em.persist(service);
        em.getTransaction().commit();
    }

    @Override
    public void update(Service service) {
        insert(service);
    }

    @Override
    public void delete(Service service) {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Service s WHERE s.id = " + service.getId()).executeUpdate();
        em.getTransaction().commit();
    }

    public Integer getMaxFee() {
        return em.createQuery("SELECT MAX(s.fee) FROM Service s", Integer.class).getSingleResult();
    }

    public Integer getLowFeeService() {
        return em.createQuery("SELECT s FROM Service s WHERE s.fee <= 50", Integer.class).getSingleResult();
    }

    public Enum getServiceType() {
        return em.createQuery("SELECT s.type FROM Service s", Enum.class).getSingleResult();
    }
}
