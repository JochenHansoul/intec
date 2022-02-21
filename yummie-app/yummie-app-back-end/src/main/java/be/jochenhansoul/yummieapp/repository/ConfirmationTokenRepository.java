package be.jochenhansoul.yummieapp.repository;

import be.jochenhansoul.yummieapp.model.user.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {
    Optional<ConfirmationToken> getConfirmationTokenByConfirmationToken(String token);
}
