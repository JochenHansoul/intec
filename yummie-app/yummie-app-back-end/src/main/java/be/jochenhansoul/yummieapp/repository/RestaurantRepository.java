package be.jochenhansoul.yummieapp.repository;

import be.jochenhansoul.yummieapp.model.restaurant.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
