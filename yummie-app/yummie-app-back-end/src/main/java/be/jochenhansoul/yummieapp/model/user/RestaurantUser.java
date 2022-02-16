package be.jochenhansoul.yummieapp.model.user;

import be.jochenhansoul.yummieapp.model.restaurant.Restaurant;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance
@NoArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
public class RestaurantUser extends User {
    @OneToMany
    private List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantUser(
            User user,
            List<Restaurant> restaurants,
            String restaurantDocumentLocation,
            boolean isValidRestaurantUser) {

        super(user);
        this.restaurants = restaurants;
    }

    public RestaurantUser(User user, Restaurant restaurant) {
        super(user);
        this.restaurants.add(restaurant);
    }

    public void addRestaurant(Restaurant restaurant) {
        this.restaurants.add(restaurant);
    }
}
