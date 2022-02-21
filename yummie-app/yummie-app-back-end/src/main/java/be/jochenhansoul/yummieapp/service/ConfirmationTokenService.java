package be.jochenhansoul.yummieapp.service;

import be.jochenhansoul.yummieapp.model.user.ConfirmationToken;
import be.jochenhansoul.yummieapp.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/*
author: Kamer Elciyar
 */

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository CONFIRMATION_TOKEN_REPOSITORY;

    void saveConfirmationToken(ConfirmationToken confirmationToken) {
        this.CONFIRMATION_TOKEN_REPOSITORY.save(confirmationToken);
    }

    void deleteConfirmationToken(Long id){
        this.CONFIRMATION_TOKEN_REPOSITORY.deleteById(id);
    }
}
