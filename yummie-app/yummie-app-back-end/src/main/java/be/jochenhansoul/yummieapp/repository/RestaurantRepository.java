package be.jochenhansoul.yummieapp.repository;

import be.jochenhansoul.yummieapp.model.restaurant.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Query("SELECT r FROM Restaurant r WHERE r.idRestaurant = :id")
    Restaurant getRestaurantByIdRestaurant(Long id);

    @Query("SELECT r FROM Restaurant r WHERE r.idRestaurantUser = :id")
    List<Restaurant> getRestaurantsByIdRestaurantUser(Long id);
}
