package be.jochenhansoul.yummieapp.controller;

import be.jochenhansoul.yummieapp.model.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @CrossOrigin
    @PostMapping
    public ResponseBody addUser(@RequestBody User user) {
        return (ResponseBody) user;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity sendUserException() {
        return ResponseEntity.status(400).body("User not created");
    }
}
