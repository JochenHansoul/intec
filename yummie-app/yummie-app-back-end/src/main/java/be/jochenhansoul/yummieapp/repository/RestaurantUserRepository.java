package be.jochenhansoul.yummieapp.repository;

import be.jochenhansoul.yummieapp.model.user.RestaurantUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantUserRepository extends JpaRepository<RestaurantUser, Long> {
    RestaurantUser getRestaurantUserByEmail(String email);
}
