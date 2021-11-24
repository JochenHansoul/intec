package be.jochenhansoul.petstore.repository;

import be.jochenhansoul.petstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUsersByUserName(String userName);

    Boolean deleteByUserName(String userName);
}
