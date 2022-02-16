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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Accessors(chain = true)
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRestaurant;

    private String name;
    /*@OneToOne
    private RestaurantAddress address;*/
    @OneToOne
    @NotNull
    private Location location;
    @NotNull
    private LocalDate creationDate = LocalDate.now();

    @NotNull
    private String restaurantCertificateLocation;
    @NotNull
    private boolean certificateIsValid = false;
    @NotNull
    private boolean isVisible = false;

    @ElementCollection
    private List<String> telephoneNumbers = new ArrayList<>();
    @ElementCollection
    private List<String> emailAddresses = new ArrayList<>();
    @ManyToMany
    private List<FoodCategory> categories = new ArrayList<>();
    @OneToMany
    private List<OpenHour> openHours = new ArrayList<>();
    @OneToMany
    private List<Dish> dishes = new ArrayList<>();
    @OneToMany
    private List<Picture> pictures = new ArrayList<>();
    @OneToMany
    private List<Review> reviews = new ArrayList<>();

    private String openHoursDescription = null;
    private String restaurantDescription = null;
}
