package be.jochenhansoul.yummieapp.service;

import be.jochenhansoul.yummieapp.model.user.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserValidator {

    public boolean validateUser(User user) {
        return user.getFirstName().length() > 5
                && user.getLastName().length() > 5
                && user.getPassword().length() > 5
                && validateEmail(user.getEmail())
                && user.getGender() != null
                && user.getBirthDate() != null
                && user.getBirthDate().isAfter(LocalDate.of(1940, 0, 0))
                && user.getBirthDate().isBefore(LocalDate.now());
    }

    public boolean validateEmail(String email) {
        String[] array = email.split("@", -1);
        return array.length == 2;
    }
}
