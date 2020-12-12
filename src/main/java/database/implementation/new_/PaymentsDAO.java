package database.implementation.new_;

import database.interfaces.FactoryCRUD;
import models.entities.new_.PaymentsEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class PaymentsDAO extends FactoryCRUD<PaymentsEntity> {
    @PersistenceContext(name = "chmnu.persistence")
    EntityManager em;

    public PaymentsDAO () {
    }

    @Override
    public PaymentsEntity getById(Integer id) {
        return em.find(PaymentsEntity.class, id);
    }

    @Override
    public List<PaymentsEntity> select() {
        return em.createQuery("select p from PaymentsEntity p").getResultList();
        // em.createNamedQuery("Clients.select", ClientsEntity.class).getResultList();
    }

    @Override
    public void insert(PaymentsEntity payment) {
        em.persist(payment);
    }

    @Override
    public void update(PaymentsEntity payment) {
        Query query = em.createQuery("update PaymentsEntity p SET p.client_id = :client_id, p.service_id = :service_id WHERE p.id = :id");
        query.setParameter("client_id", payment.getClient_id());
        query.setParameter("service_id", payment.getService_id());
        query.setParameter("id", payment.getId());
        query.executeUpdate();
        em.createNamedQuery("Payments.select", PaymentsEntity.class).getResultList();
    }

    @Override
    public void delete(PaymentsEntity payment) {
        Query query = em.createQuery("DELETE FROM PaymentsEntity p WHERE p.id = :id");
        query.setParameter("id", payment.getId());
        query.executeUpdate();
        em.createNamedQuery("Payments.select", PaymentsEntity.class).getResultList();
    }
}
