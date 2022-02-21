package be.jochenhansoul.yummieapp.controller;

import be.jochenhansoul.yummieapp.model.user.ConfirmationToken;
import be.jochenhansoul.yummieapp.model.user.User;
import be.jochenhansoul.yummieapp.service.ConfirmationTokenService;
import be.jochenhansoul.yummieapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService USER_SERVICE;
    private final ConfirmationTokenService CONFIRMATION_TOKEN_SERVICE;

    public UserController(UserService userService, ConfirmationTokenService confirmationTokenService) {
        this.USER_SERVICE = userService;
        this.CONFIRMATION_TOKEN_SERVICE = confirmationTokenService;
    }

    @CrossOrigin
    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        this.USER_SERVICE.signUpUser(user);

        Optional<User> optionalUser = this.USER_SERVICE.loginUser(user.getEmail(), user.getPassword());
        if (optionalUser.isPresent()) {
            User savedUser = optionalUser.get();
            return ResponseEntity.status(201).body("{\"idUser\":\"" + savedUser.getIdUser()
                    + "\",\"nameUser\":\"" + savedUser.getFirstName() + " " + savedUser.getLastName() + "\"}"); // "{\"key\":\"value\"}"
        } else {
            return ResponseEntity.status(422).body("user not created");
        }
    }

    @CrossOrigin
    @PostMapping("/sign-in")
    public ResponseEntity<String> signIn(@RequestBody User user) {
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

    @GetMapping("/confirm")
    public String confirmMail(@RequestParam("token") String token) {
        Optional<ConfirmationToken> optionalConfirmationToken = this.CONFIRMATION_TOKEN_SERVICE.findConfirmationTokenByToken(token);
        optionalConfirmationToken.ifPresent(this.USER_SERVICE::confirmUser);
        return "/sign-in";
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> sendUserException() {
        System.out.println("inside sendUserException");
        return ResponseEntity.status(400).body("{\"value\":\"User not created\"}"); // doesn't seem to matter if return string or json string
    }
}
