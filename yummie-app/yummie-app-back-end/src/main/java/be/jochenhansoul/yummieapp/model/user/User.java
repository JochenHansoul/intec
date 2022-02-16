package be.jochenhansoul.yummieapp.model.user;

import be.jochenhansoul.yummieapp.model.general.Location;
import be.jochenhansoul.yummieapp.model.restaurant.Restaurant;
import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @NotNull
    //@Column(unique = true)
    private String email;
    @NotNull
    private String password;
    @NotNull
    private boolean isRestaurantUser = false;
    @NotNull
    private LocalDate creationDate = LocalDate.now();
    @NotNull
    private boolean isValidated = false;
    @OneToOne
    private UserAddress address  = null;
    private String telephone  = null;
    @OneToOne
    private Location defaultSearchLocation = null;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Restaurant> restaurants = new ArrayList<>();

    public void addRestaurant(Restaurant restaurant) {
        this.restaurants.add(restaurant);
    }
}
