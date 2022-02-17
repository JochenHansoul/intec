package be.jochenhansoul.yummieapp.repository;

import be.jochenhansoul.yummieapp.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUsersByIdUser(Long id);
    User getUsersByEmail(String email);
}
