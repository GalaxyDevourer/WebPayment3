package models.beans.new_;

import database.implementation.new_.PaymentsDAO;
import models.entities.new_.PaymentsEntity;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("paymentsBean")
@SessionScoped
public class PaymentsBean implements Serializable {
    private PaymentsDAO paymentsDAO;
    private PaymentsEntity payment;

    public PaymentsBean () {
        this.paymentsDAO = new PaymentsDAO();
    }

    @PostConstruct
    public void init() {
        payment = new PaymentsEntity();
    }

    public List<PaymentsEntity> getPayments() {
        return paymentsDAO.select();
    }

    public String updatePayments() {
        System.out.println("DEBUG: " + payment.toString());
        if(payment.getId() == 0) {
            paymentsDAO.insert(payment);
        } else {
            paymentsDAO.update(payment);
        }
        return "clients";
    }

    public String deletePayments() {
        paymentsDAO.delete(payment);
        return "clients";
    }

    public PaymentsDAO getPaymentsDAO() {
        return paymentsDAO;
    }

    public void setPaymentsDAO(PaymentsDAO paymentsDAO) {
        this.paymentsDAO = paymentsDAO;
    }

    public PaymentsEntity getPayment() {
        return payment;
    }

    public void setPayment(PaymentsEntity payment) {
        this.payment = payment;
    }
}
