package be.jochenhansoul.yummieapp.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Accessors(chain = true)
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRestaurant;
    private String name;
    @OneToMany
    private List<TelephoneNumber> telephoneNumbers;
    @OneToMany
    private List<EmailAddress> emailAddresses;
    @ManyToMany
    private List<FoodCategory> categories;
    private String restaurantDescription;
    @OneToMany
    private List<OpenHour> openHours;
    private String openHoursDescription;
    @OneToMany
    private List<Dish> dishes;
    @OneToOne
    @NotNull
    private Location location;
    @OneToMany
    private List<Picture> pictures;
    @OneToMany
    private List<Review> reviews;
    private boolean isVisible;
}
