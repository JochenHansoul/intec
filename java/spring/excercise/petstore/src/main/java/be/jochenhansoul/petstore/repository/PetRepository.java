package be.jochenhansoul.petstore.repository;

import be.jochenhansoul.petstore.model.Pet;
import be.jochenhansoul.petstore.model.PetStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    Pet getById(Long id);

    void deleteById(Long id);

    List<Pet> getPetsByStatus(PetStatus status);
}
