package be.jochenhansoul.springdata.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
public class Cake {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer size;
    private Boolean hasChocolate;

    public Cake(String name, Integer size, Boolean hasChocolate) {
        this.name = name;
        this.size = size;
        this.hasChocolate = hasChocolate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cake cake = (Cake) o;
        return id != null && Objects.equals(id, cake.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
