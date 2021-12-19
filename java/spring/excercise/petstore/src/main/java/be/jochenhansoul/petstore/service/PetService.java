package be.jochenhansoul.petstore.service;

import be.jochenhansoul.petstore.model.Pet;
import be.jochenhansoul.petstore.model.PetStatus;
import be.jochenhansoul.petstore.repository.PetRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class PetService {
    private final PetValidator PET_VALIDATOR;
    private final PetRepository PET_REPOSITORY;

    public PetService(PetValidator petValidator, PetRepository petRepository) {
        this.PET_VALIDATOR = petValidator;
        this.PET_REPOSITORY = petRepository;
    }

    public Optional<Pet> save(Pet pet) {
        return (this.PET_VALIDATOR.validate(pet))
                ? Optional.of(this.PET_REPOSITORY.save(pet))
                : Optional.empty();
    }

    public Optional<Pet> getPet(long id) {
        return (this.PET_REPOSITORY.existsById(id))
                ? Optional.of(this.PET_REPOSITORY.getPetById(id))
                : Optional.empty();
    }

    public Pet update(long id, String name) {
        if (!this.PET_REPOSITORY.existsById(id)) {
            throw new IllegalArgumentException("Could not find pet with id " + id);
        } else if (!PET_VALIDATOR.validateName(name)) {
            throw new IllegalArgumentException("Pet name is illegal");
        } else {
            return PET_REPOSITORY.updatePet(id, name);
        }
    }

    public Pet update(long id, PetStatus status) {
        if (!this.PET_REPOSITORY.existsById(id)) {
            throw new IllegalArgumentException("Could not find pet with id " + id);
        } else if (status == null) {
            throw new IllegalArgumentException("Pet status is illegal");
        } else {
            return PET_REPOSITORY.updatePet(id, status);
        }
    }

    public Optional<Pet> update(Pet pet) {
        if (this.PET_REPOSITORY.existsById(pet.getId())) {
            return Optional.of(this.PET_REPOSITORY.save(pet));
        } else {
            return Optional.empty();
        }
    }

    public List<Pet> findByStatus(Set<PetStatus> statuses) {
        List<Pet> pets = new ArrayList<>();
        for (PetStatus status : statuses) {
            pets.addAll(this.PET_REPOSITORY.getPetsByStatus(status));
        }
        return pets;
    }

    public boolean delete(Long id) {
        if (PET_REPOSITORY.existsById(id)) {
            PET_REPOSITORY.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public boolean uploadImage(long id, String url) {
        if (PET_REPOSITORY.existsById(id) && url != null && url.length() > 0) {
            PET_REPOSITORY.addPhotoUrl(id, url);
            return true;
        } else {
            return false;
        }
    }
}
