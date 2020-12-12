package database.implementation.old;

import database.interfaces.FactoryCRUD;
import models.entities.old.Payment;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PaymentDAO extends FactoryCRUD<Payment> {
    @PersistenceContext(name = "chmnu.persistence")
    EntityManager em;

    public PaymentDAO () {
    }

    @Override
    public Payment getById(Integer id) {
        return em.find(Payment.class, id);
    }

    @Override
    public List<Payment> select() {
        return em.createNamedQuery("Payment.select", Payment.class).getResultList();
    }

    @Override
    public void insert(Payment payment) {
        em.getTransaction().begin();
        em.persist(payment);
        em.getTransaction().commit();
    }

    @Override
    public void update(Payment payment) {
        insert(payment);
    }

    @Override
    public void delete(Payment payment) {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Payment p WHERE p.id = " + payment.getId()).executeUpdate();
        em.getTransaction().commit();
    }
}
