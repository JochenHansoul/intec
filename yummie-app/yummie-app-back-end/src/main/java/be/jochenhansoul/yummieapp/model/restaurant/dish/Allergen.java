package be.jochenhansoul.yummieapp.model.restaurant.dish;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@Accessors(chain = true)
public class Allergen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAllergen;
    private String name;
}
