package database.implementation;

import database.interfaces.FactoryCRUD;
import models.entities.Payment;

import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Stateless
public class PaymentDAO extends FactoryCRUD<Payment> {

    public PaymentDAO () {
        EntityManagerFactory ef = Persistence.createEntityManagerFactory("chmnu.persistence");
        em = ef.createEntityManager();
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
    public void checkPersist(Payment payment) {
        em.getTransaction().begin();
        em.persist(payment);
        em.getTransaction().commit();
    }

    @Override
    public void update(Payment payment) {
        checkPersist(payment);
    }

    @Override
    public void delete(Payment payment) {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Payment p WHERE p.id = " + payment.getId()).executeUpdate();
        em.getTransaction().commit();
    }
}
