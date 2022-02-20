package be.jochenhansoul.yummieapp.repository;

import be.jochenhansoul.yummieapp.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUsersByIdUser(Long id);
    Optional<User> getUsersByEmail(String email);
}
