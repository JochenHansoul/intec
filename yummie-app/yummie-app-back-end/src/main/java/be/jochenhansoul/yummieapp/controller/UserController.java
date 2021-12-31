package be.jochenhansoul.yummieapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping
    public ResponseEntity addUser(@RequestParam("name") String name, @RequestParam("password") String password) {
        return ResponseEntity.ok("user created: " + name + " " + password);
    }
}
