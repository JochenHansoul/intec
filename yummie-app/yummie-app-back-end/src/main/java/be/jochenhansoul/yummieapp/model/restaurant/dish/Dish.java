package be.jochenhansoul.yummieapp.model.restaurant.dish;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Accessors(chain = true)
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDish;
    private String name;
    private String pictureUrl;
    private float price;
    @OneToMany
    private List<Allergen> allergenList;
}
