package be.jochenhansoul.yummieapp.controller;

import be.jochenhansoul.yummieapp.model.restaurant.Restaurant;
import be.jochenhansoul.yummieapp.service.RestaurantService;
import be.jochenhansoul.yummieapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("restaurant")
public class RestaurantController {

    private final RestaurantService RESTAURANT_SERVICE;
    private final UserService USER_SERVICE;

    public RestaurantController(RestaurantService restaurant_service, UserService user_service) {
        this.RESTAURANT_SERVICE = restaurant_service;
        this.USER_SERVICE = user_service;
    }

    @PostMapping("/create")
    public ResponseEntity<String> addRestaurant(@RequestBody Restaurant restaurant) {
        Optional<Restaurant> optionalRestaurant = this.RESTAURANT_SERVICE.saveRestaurantAndAddToUser(restaurant);
        return optionalRestaurant.map(value -> (this.USER_SERVICE.addRestaurantToUser(value).isPresent())
                ? ResponseEntity.status(201).body("") : ResponseEntity.status(400).body("Could not add restaurant to user."))
                .orElseGet(() -> ResponseEntity.status(400).body("Could not add restaurant to database."));
    }
}
