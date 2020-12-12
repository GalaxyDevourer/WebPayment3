package models.entities.new_;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "payments", schema = "webpayment")
@NamedQueries({
        @NamedQuery(name = "Payments.select", query = "select p from PaymentsEntity p")
})
public class PaymentsEntity {
    private int id;
    private int client_id;
    private int service_id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @NotNull
    @Column(name = "client_id", nullable = false)
    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    @Basic
    @NotNull
    @Column(name = "service_id", nullable = false)
    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentsEntity)) return false;
        PaymentsEntity that = (PaymentsEntity) o;
        return id == that.id &&
                client_id == that.client_id &&
                service_id == that.service_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client_id, service_id);
    }
}
