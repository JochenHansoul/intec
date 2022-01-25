package be.jochenhansoul.yummieapp.model.restaurant;

import be.jochenhansoul.yummieapp.model.general.Location;
import be.jochenhansoul.yummieapp.model.restaurant.dish.Dish;
import be.jochenhansoul.yummieapp.model.user.Email;
import be.jochenhansoul.yummieapp.model.user.Telephone;
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
    @OneToOne
    private RestaurantAddress address;
    @OneToMany
    private List<Telephone> telephoneNumbers;
    @OneToMany
    private List<Email> emailAddresses;
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
