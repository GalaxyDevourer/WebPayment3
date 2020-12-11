package models.beans;

import database.implementation.PaymentDAO;
import models.entities.Payment;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean("paymentBean")
@SessionScoped
public class PaymentBean implements Serializable {
    private PaymentDAO paymentDAO;
    private Payment payment;

    public PaymentBean () {
        this.paymentDAO = new PaymentDAO();
    }

    public List<Payment> getPayments() {
        return paymentDAO.select();
    }

    public void updatePayment() {
        if(payment.getId() == null) {
            paymentDAO.checkPersist(payment);
        } else {
            paymentDAO.update(payment);
        }
    }

    public void deletePayment() {
        paymentDAO.delete(payment);
    }

    public PaymentDAO getPaymentDAO() {
        return paymentDAO;
    }

    public void setPaymentDAO(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}