package models.entities.old;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Table
@Entity
@NamedQueries({
        @NamedQuery(name = "Client.select", query = "select c from clients c")
})
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Size(max = 30, message = "The name too long (max = 30)")
    String name;

    public Client () {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
