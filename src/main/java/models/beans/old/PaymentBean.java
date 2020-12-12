package models.beans.old;

import database.implementation.old.PaymentDAO;
import models.entities.old.Payment;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("paymentBean")
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
            paymentDAO.insert(payment);
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