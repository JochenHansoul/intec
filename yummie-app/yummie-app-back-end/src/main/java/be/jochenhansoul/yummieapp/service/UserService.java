package be.jochenhansoul.yummieapp.service;

import be.jochenhansoul.yummieapp.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    private final UserRepository USER_REPOSITORY;
    private final UserValidator USER_VALIDATOR;

    public UserService(UserRepository userRepository, UserValidator userValidator) {
        this.USER_REPOSITORY = userRepository;
        this.USER_VALIDATOR = userValidator;
    }
}
