package be.jochenhansoul.yummieapp.service;

import be.jochenhansoul.yummieapp.model.user.ConfirmationToken;
import be.jochenhansoul.yummieapp.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*
author: Kamer Elciyar
 */

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository CONFIRMATION_TOKEN_REPOSITORY;

    public void saveConfirmationToken(ConfirmationToken confirmationToken) {
        this.CONFIRMATION_TOKEN_REPOSITORY.save(confirmationToken);
    }

    public void deleteConfirmationToken(Long id){
        this.CONFIRMATION_TOKEN_REPOSITORY.deleteById(id);
    }

    public Optional<ConfirmationToken> findConfirmationTokenByToken(String token) {
        return this.CONFIRMATION_TOKEN_REPOSITORY.getConfirmationTokenByConfirmationToken(token);
    }
}
