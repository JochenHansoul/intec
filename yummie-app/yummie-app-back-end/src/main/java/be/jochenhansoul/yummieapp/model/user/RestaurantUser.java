package be.jochenhansoul.yummieapp.model.user;

import be.jochenhansoul.yummieapp.model.restaurant.Restaurant;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Accessors(chain = true)
public class RestaurantUser extends User {
    @OneToMany(fetch = FetchType.EAGER)
    private List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantUser(User user, Restaurant restaurant) {
        super(user);
        this.restaurants.add(restaurant);
    }

    public void addRestaurant(Restaurant restaurant) {
        this.restaurants.add(restaurant);
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.restaurants.toString();
    }
}
