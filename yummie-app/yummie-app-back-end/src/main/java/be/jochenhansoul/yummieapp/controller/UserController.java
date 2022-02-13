package be.jochenhansoul.yummieapp.controller;

import be.jochenhansoul.yummieapp.model.user.User;
import be.jochenhansoul.yummieapp.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
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
    public ResponseEntity<String> addUser(@RequestBody User user) throws JsonProcessingException {
        //System.out.println("successfully created user " + user);
        Optional<User> optionalUser = this.USER_SERVICE.saveUser(user);
        //System.out.println("after user service");
        if (optionalUser.isPresent()) {
            User savedUser = optionalUser.get();
            //System.out.println(savedUser);
            /*ObjectMapper mapper = new ObjectMapper();
            System.out.println("turning into a json string:");
            String json = mapper.writeValueAsString(savedUser);
            System.out.println("ResultingJSONstring = " + json);*/
            return ResponseEntity.status(201).body("{\"email\":\"" + savedUser.getEmail() + "\",\"password\":\"" + user.getPassword() + "\"}"); // "{\"key\":\"value\"}"
        } else {
            return ResponseEntity.status(422).body("user not created");
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> sendUserException() {
        System.out.println("inside sendUserException");
        return ResponseEntity.status(400).body("{\"value\":\"User not created\"}"); // doesn't seem to matter if return string or json string
    }
}
