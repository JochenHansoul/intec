package be.jochenhansoul.petstore.service;

import be.jochenhansoul.petstore.model.Pet;
import be.jochenhansoul.petstore.model.PetStatus;
import be.jochenhansoul.petstore.repository.PetRepository;

import java.util.List;
import java.util.Optional;

public class PetService {
    private final PetValidator PET_VALIDATOR;
    private final PetRepository PET_REPOSITORY;

    public PetService(PetValidator petValidator, PetRepository petRepository) {
        this.PET_VALIDATOR = petValidator;
        this.PET_REPOSITORY = petRepository;
    }

    public Optional<Pet> save(Pet pet) {
        if (this.PET_VALIDATOR.validate(pet)) {
            return Optional.of(this.PET_REPOSITORY.save(pet));
        } else {
            return Optional.empty();
        }
    }

    public int update(long id, String name, String status) {
        PetStatus petStatus = null;
        try {
            petStatus = PetStatus.valueOf(status);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        if (name == null || petStatus == null || !this.PET_REPOSITORY.existsById(id)) {
            return 405;
        } else {
            // update pet
            return 200;
        }
    }

    public int update(Pet pet) {
        if (this.PET_VALIDATOR.validate(pet)) {
            if (this.PET_REPOSITORY.existsById(pet.getId())) {
                this.PET_REPOSITORY.save(pet);
                return 200;
            } else {
                return 404;
            }
        } else {
            return 405;
        }
    }

    public List<Pet> findByStatus(String status) {
        return this.PET_REPOSITORY.getPetsByStatus(PetStatus.valueOf(status));
    }
}