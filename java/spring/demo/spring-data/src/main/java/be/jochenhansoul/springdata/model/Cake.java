package be.jochenhansoul.springdata.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Cake {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer size;
    private String name;
    private Boolean hasChocolate;
}
