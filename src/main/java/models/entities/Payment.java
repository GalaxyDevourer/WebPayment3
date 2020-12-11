package models.entities;

import javax.persistence.*;

@Table
@Entity
@NamedQueries({
        @NamedQuery(name = "Payment.select", query = "select p from Payment p")
})
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Basic
    @Column(name = "client_id")
    int clientId;
    @Basic
    @Column(name = "service_id")
    int serviceId;

    public Payment () {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }
}
