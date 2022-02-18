package be.jochenhansoul.yummieapp.controller;

import be.jochenhansoul.yummieapp.model.user.User;
import be.jochenhansoul.yummieapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService USER_SERVICE;

    public UserController(UserService userService) {
        this.USER_SERVICE = userService;
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody User user) {
        Optional<User> optionalUser = this.USER_SERVICE.saveUser(user);
        if (optionalUser.isPresent()) {
            User savedUser = optionalUser.get();
            return ResponseEntity.status(201).body("{\"idUser\":\"" + savedUser.getIdUser()
                    + "\",\"nameUser\":\"" + savedUser.getFirstName() + " " + savedUser.getLastName() + "\"}"); // "{\"key\":\"value\"}"
        } else {
            return ResponseEntity.status(422).body("user not created");
        }
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        // create method that does the same code
        Optional<User> optionalUser = this.USER_SERVICE.loginUser(user.getEmail(), user.getPassword());
        if (optionalUser.isPresent()) {
            User savedUser = optionalUser.get();
            return ResponseEntity.status(201).body("{\"idUser\":\"" + savedUser.getIdUser()
                    + "\",\"nameUser\":\"" + savedUser.getFirstName() + " " + savedUser.getLastName() + "\"}"); // "{\"key\":\"value\"}"
        } else {
            return ResponseEntity.status(422).body("user not found");
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> sendUserException() {
        System.out.println("inside sendUserException");
        return ResponseEntity.status(400).body("{\"value\":\"User not created\"}"); // doesn't seem to matter if return string or json string
    }
}
