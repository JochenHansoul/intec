package be.jochenhansoul.yummieapp.model.restaurant;

import be.jochenhansoul.yummieapp.model.general.Location;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Setter
@Getter
@Accessors(chain = true)
@ToString
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRestaurant;
    private Long idUser;

    private String name;
    /*@OneToOne
    private RestaurantAddress address;*/
    @OneToOne
    @NotNull
    private Location location;
    /*@NotNull
    private LocalDate creationDate = LocalDate.now();*/

    @NotNull
    private String restaurantCertificateLocation;
    @NotNull
    private boolean certificateIsValid = false;
    @NotNull
    private boolean isVisible = false;

    /*@ElementCollection
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
    private List<Review> reviews = new ArrayList<>();*/

    private String openHoursDescription = null;
    private String restaurantDescription = null;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return idRestaurant.equals(that.idRestaurant) && idUser.equals(that.idUser) && name.equals(that.name) && location.equals(that.location) /*&& creationDate.equals(that.creationDate)*/ && restaurantCertificateLocation.equals(that.restaurantCertificateLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRestaurant, idUser, name, location/*, creationDate*/, restaurantCertificateLocation);
    }
}
