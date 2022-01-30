package be.jochenhansoul.yummieapp.controller;

import be.jochenhansoul.yummieapp.model.user.Gender;
import be.jochenhansoul.yummieapp.model.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping
    public ResponseEntity addUser(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("gender") Gender gender,
            @RequestParam("password") String password) {
        User user = new User();
        user
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setPassword(password)
                .setCreationDate(LocalDate.now());
        return ResponseEntity.ok(user.toString());
    }
}
