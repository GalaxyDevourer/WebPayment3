package models.entities.old;

import models.entities.ServiceType;
import models.validators.Fee;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table
@SecondaryTable(name = "services_titles")
@NamedQueries({
        @NamedQuery(name = "Service.select", query = "select s from Service s")
})
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title", table = "services_titles")
    @Pattern(regexp = "[A-Za-z]{3,15}")
    private String title = "";
    @Fee
    private Integer fee = 0;
    @Enumerated(EnumType.STRING)
    private ServiceType type;

    public Service () {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public ServiceType getType() {
        return type;
    }

    public void setType(ServiceType type) {
        this.type = type;
    }
}
