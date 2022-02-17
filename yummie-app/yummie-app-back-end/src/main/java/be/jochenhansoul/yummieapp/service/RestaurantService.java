package be.jochenhansoul.yummieapp.service;

import be.jochenhansoul.yummieapp.model.general.Location;
import be.jochenhansoul.yummieapp.model.restaurant.Restaurant;
import be.jochenhansoul.yummieapp.repository.RestaurantRepository;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RestaurantService {

    private final RestaurantValidator RESTAURANT_VALIDATOR;
    private final RestaurantRepository RESTAURANT_REPOSITORY;

    public RestaurantService(RestaurantValidator RESTAURANT_VALIDATOR, RestaurantRepository RESTAURANT_REPOSITORY) {
        this.RESTAURANT_VALIDATOR = RESTAURANT_VALIDATOR;
        this.RESTAURANT_REPOSITORY = RESTAURANT_REPOSITORY;
    }

    public Optional<Restaurant> saveRestaurantAndAddToUser(Restaurant restaurant) {
        return (this.RESTAURANT_VALIDATOR.validateRestaurant(restaurant))
                ? Optional.of(this.RESTAURANT_REPOSITORY.save(restaurant))
                : Optional.empty();
    }

    public List<Restaurant> getRestaurantClosestTo(Location location) {
        List<Restaurant> restaurantList = this.RESTAURANT_REPOSITORY.findAll();
        /*Map<Restaurant, Double> restaurantMap = new HashMap<>();
        for (Restaurant restaurant : restaurantList) {
            restaurantMap.put(restaurant, location.getDistance(restaurant.getLocation()));
        }
        List<Map.Entry<Restaurant, Double>> list = new ArrayList<>(restaurantMap.entrySet());
        list.sort(Map.Entry.comparingByValue());*/

        // not sure if works
        restaurantList.sort((restaurant, t1) -> (int) restaurant.getLocation().getDistance(location));
        return restaurantList;
    }
}
