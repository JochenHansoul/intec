package be.jochenhansoul.yummieapp.model.restaurant;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Accessors(chain = true)
public class RestaurantAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAddress;
    private String country;
    private String zipCode;
    private String street;
    private String number;
    private boolean mainAddress;
}
