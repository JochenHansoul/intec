package be.jochenhansoul.yummieapp.repository;

import be.jochenhansoul.yummieapp.model.user.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {
}
