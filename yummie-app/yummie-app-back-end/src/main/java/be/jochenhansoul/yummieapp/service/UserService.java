package be.jochenhansoul.yummieapp.service;

import be.jochenhansoul.yummieapp.model.restaurant.Restaurant;
import be.jochenhansoul.yummieapp.model.user.User;
import be.jochenhansoul.yummieapp.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService {
    private final UserRepository USER_REPOSITORY;
    private final UserValidator USER_VALIDATOR;

    public UserService(UserRepository userRepository, UserValidator userValidator) {
        this.USER_REPOSITORY = userRepository;
        this.USER_VALIDATOR = userValidator;
    }

    public Optional<User> saveUser(User user) {
        return (this.USER_VALIDATOR.validateUser(user))
                ? Optional.of(this.USER_REPOSITORY.save(user))
                : Optional.empty();
    }

    public Optional<User> addRestaurantToUser(Restaurant restaurant) {
        User user = this.USER_REPOSITORY.getUsersByIdUser(restaurant.getIdUser());
        if (user != null) {
            user.addRestaurant(restaurant);
            return Optional.of(this.USER_REPOSITORY.save(user));
        } else {
            return Optional.empty();
        }
    }
}
