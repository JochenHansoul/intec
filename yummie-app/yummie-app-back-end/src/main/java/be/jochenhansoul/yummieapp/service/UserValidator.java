package be.jochenhansoul.yummieapp.service;

import be.jochenhansoul.yummieapp.model.user.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserValidator {

    public boolean validateUser(User user) {
        return user.getFirstName().length() > 2
                && user.getLastName().length() > 2
                && user.getPassword().length() > 2
                && validateEmail(user.getEmail())
                && user.getGender() != null
                && user.getBirthDate() != null
                && user.getBirthDate().isAfter(LocalDate.parse("1930-03-03"))
                && user.getBirthDate().isBefore(LocalDate.now());
    }

    public boolean validateEmail(String email) {
        String[] array = email.split("@", -1);
        return array.length == 2;
    }
}
