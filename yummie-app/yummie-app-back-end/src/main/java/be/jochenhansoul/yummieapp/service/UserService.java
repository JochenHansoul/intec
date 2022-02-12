package be.jochenhansoul.yummieapp.service;

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
        return Optional.of(USER_REPOSITORY.save(user));
    }
}
