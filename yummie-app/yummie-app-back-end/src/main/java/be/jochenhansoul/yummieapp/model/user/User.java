package be.jochenhansoul.yummieapp.model.user;

import be.jochenhansoul.yummieapp.model.general.Location;
import be.jochenhansoul.yummieapp.model.restaurant.Restaurant;
import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Gender gender;
    @NotNull
    private LocalDate birthDate;
    @OneToOne
    private UserAddress address  = null;
    private String telephone  = null;

    @NotNull
    //@Column(unique = true)
    private String email;
    @NotNull
    private String password;

    @NotNull
    private UserType userType = UserType.USER;
    @NotNull
    private LocalDate creationDate = LocalDate.now();
    @NotNull
    private boolean isValidated = false;

    @OneToOne
    private Location defaultSearchLocation = null;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Restaurant> favoriteRestaurants = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Restaurant> ownedRestaurants = new HashSet<>();

    // methods
    public void addFavoriteRestaurant(Restaurant restaurant) {
        this.favoriteRestaurants.add(restaurant);
    }

    public void addRestaurant(Restaurant restaurant) {
        this.ownedRestaurants.add(restaurant);
    }
}
