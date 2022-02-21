package be.jochenhansoul.yummieapp.service;

import be.jochenhansoul.yummieapp.model.restaurant.Restaurant;
import be.jochenhansoul.yummieapp.model.user.ConfirmationToken;
import be.jochenhansoul.yummieapp.model.user.User;
import be.jochenhansoul.yummieapp.repository.UserRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository USER_REPOSITORY;
    private final UserValidator USER_VALIDATOR;
    private final ConfirmationTokenService CONFIRMATION_TOKEN_SERVICE;
    private final EmailSenderService EMAIL_SENDER_SERVICE;
    private final BCryptPasswordEncoder BCRYPT_PASSWORD_ENCODER;

    public UserService(
            UserRepository userRepository,
            UserValidator userValidator,
            ConfirmationTokenService confirmationTokenService,
            EmailSenderService emailSenderService,
            BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.USER_REPOSITORY = userRepository;
        this.USER_VALIDATOR = userValidator;
        this.CONFIRMATION_TOKEN_SERVICE = confirmationTokenService;
        this.EMAIL_SENDER_SERVICE = emailSenderService;
        this.BCRYPT_PASSWORD_ENCODER = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.USER_REPOSITORY.getUsersByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " not found"));
    }

    public void signUpUser(User user) {
        user.setPassword(this.BCRYPT_PASSWORD_ENCODER.encode(user.getPassword()));
        final User createdUser = this.USER_REPOSITORY.save(user);
        final ConfirmationToken confirmationToken = new ConfirmationToken(user);
        this.CONFIRMATION_TOKEN_SERVICE.saveConfirmationToken(confirmationToken);
    }

    public void sendConfirmationMail(String userMail, String token) {
        final SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userMail);
        mailMessage.setSubject("Mail Confirmation Link!");
        mailMessage.setFrom("<MAIL>");
        mailMessage.setText(
                "Thank you for registering. Please click on the below link to activate your account." + "http://localhost:8080/sign-up/confirm?token="
                        + token);
        this.EMAIL_SENDER_SERVICE.sendEmail(mailMessage);
    }

    public void confirmUser(ConfirmationToken confirmationToken) {
        final User user = confirmationToken.getUser();
        user.setEnabled(true);
        this.USER_REPOSITORY.save(user);
        this.CONFIRMATION_TOKEN_SERVICE.deleteConfirmationToken(confirmationToken.getId());

    }

    public Optional<User> saveUser(User user) {
        return (this.USER_VALIDATOR.validateUser(user))
                ? Optional.of(this.USER_REPOSITORY.save(user))
                : Optional.empty();
    }

    public Optional<User> loginUser(String email, String password) {
        Optional<User> user = this.USER_REPOSITORY.getUsersByEmail(email);
        return (user.isEmpty() || !user.get().getPassword().equals(password))
                ? Optional.empty()
                : user;
    }

    public Optional<User> addRestaurantToUser(Restaurant restaurant) {
        User user = this.USER_REPOSITORY.getUsersByIdUser(restaurant.getIdUser());
        if (user != null) {
            user.addRestaurant(restaurant);
            return Optional.of(this.USER_REPOSITORY.save(user));
        } else {
            return Optional.empty();
        }
    }
}
