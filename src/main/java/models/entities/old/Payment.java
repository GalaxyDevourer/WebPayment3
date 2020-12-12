package models.entities.old;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    @NotNull
    @Column(name = "client_id")
    int clientId;
    @Basic
    @NotNull
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
