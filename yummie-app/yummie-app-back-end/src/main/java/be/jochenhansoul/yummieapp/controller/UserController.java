package be.jochenhansoul.yummieapp.controller;

import be.jochenhansoul.yummieapp.model.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping
    public ResponseEntity addUser(@RequestBody User user) {
        System.out.println(user);
        return ResponseEntity.status(201).body(user);
    }
}
