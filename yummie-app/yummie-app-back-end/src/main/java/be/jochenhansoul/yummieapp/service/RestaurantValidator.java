package be.jochenhansoul.yummieapp.service;

import be.jochenhansoul.yummieapp.model.restaurant.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class RestaurantValidator {

    public boolean validateRestaurant(Restaurant restaurant) {
        return restaurant.getName().length() > 1
                && restaurant.getLocation() != null;
        // todo: location validator
    }
}
