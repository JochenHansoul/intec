package be.jochenhansoul.yummieapp.controller;

import be.jochenhansoul.yummieapp.model.user.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @CrossOrigin
    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody User user) throws JsonProcessingException {
        System.out.println("successfully created user");
        //System.out.println(user);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        //System.out.println("ResultingJSONstring = " + json);
        return ResponseEntity.status(201).body(json); // "{\"json\":\"user\"}"
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> sendUserException() {
        System.out.println("inside sendUserException");
        return ResponseEntity.status(400).body("{\"value\":\"User not created\"}"); // doesn't seem to matter if return string or json string
    }
}
