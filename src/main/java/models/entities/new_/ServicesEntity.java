package models.entities.new_;

import models.validators.Fee;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Entity
@Table(name = "services", schema = "webpayment")
public class ServicesEntity {
    private int id;
    private String title;
    @Fee private int fee;
    private Object type;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, length = -1)
    @Pattern(regexp = "[A-Za-z]{3,15}")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "fee", nullable = false)
    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    @Basic
    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServicesEntity that = (ServicesEntity) o;
        return id == that.id &&
                fee == that.fee &&
                Objects.equals(title, that.title) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, fee, type);
    }
}
