package be.jochenhansoul.yummieapp.controller;

import be.jochenhansoul.yummieapp.model.general.Location;
import be.jochenhansoul.yummieapp.model.restaurant.Restaurant;
import be.jochenhansoul.yummieapp.service.LocationService;
import be.jochenhansoul.yummieapp.service.RestaurantService;
import be.jochenhansoul.yummieapp.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("restaurant")
public class RestaurantController {

    private final ObjectMapper MAPPER = new ObjectMapper(); // throws JsonProcessingException

    private final LocationService LOCATION_SERVICE;
    private final RestaurantService RESTAURANT_SERVICE;
    private final UserService USER_SERVICE;

    public RestaurantController(LocationService locationService, RestaurantService restaurant_service, UserService user_service) {
        this.LOCATION_SERVICE = locationService;
        this.RESTAURANT_SERVICE = restaurant_service;
        this.USER_SERVICE = user_service;
    }

    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<String> addRestaurant(@RequestBody Restaurant restaurant) {
        Optional<Location> optionalLocation = this.LOCATION_SERVICE.saveLocation(restaurant.getLocation());
        if (optionalLocation.isPresent()) {
            restaurant.setLocation(optionalLocation.get());
            Optional<Restaurant> optionalRestaurant = this.RESTAURANT_SERVICE.saveRestaurantAndAddToUser(restaurant);
            return optionalRestaurant.map(value -> (this.USER_SERVICE.addRestaurantToUser(value).isPresent())
                            ? ResponseEntity.status(201).body("{\"idRestaurant\":\"" + optionalRestaurant.get().getIdRestaurant() + "\"}")
                            : ResponseEntity.status(400).body("Could not add restaurant to user."))
                    .orElseGet(() -> ResponseEntity.status(400).body("Could not add restaurant to database."));
        } else {
            return ResponseEntity.status(400).body("Could not add location to database.");
        }
    }

    @CrossOrigin
    @PostMapping("/get")
    public ResponseEntity<String> getRestaurantsBasedOnLocation(
            @RequestBody Location location,
            @RequestParam(name = "id", required = false) Long id) throws JsonProcessingException {
        // id can later be used to get preferences
        List<Restaurant> restaurantList = this.RESTAURANT_SERVICE.getRestaurantClosestTo(location);
        String json = MAPPER.writeValueAsString(restaurantList);
        return ResponseEntity.status(200).body(json); //"{\"key\":\"value\"}"
    }
}
