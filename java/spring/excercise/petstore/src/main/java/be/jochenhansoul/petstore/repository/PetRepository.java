package be.jochenhansoul.petstore.repository;

import be.jochenhansoul.petstore.model.Pet;
import be.jochenhansoul.petstore.model.PetStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    @Query("SELECT p FROM Pet p WHERE p.id = :id")
    Pet getPetById(Long id);

    void deleteById(Long id);

    List<Pet> getPetsByStatus(PetStatus status);

    @Query("UPDATE Pet p SET p.name = :name WHERE p.id = :id")
    Pet updatePet(Long id, String name);

    @Query("UPDATE Pet p SET p.status = :status WHERE p.id = :id")
    Pet updatePet(Long id, PetStatus status);

    // native query
    @Query(value = "INSERT INTO pet_photo_urls VALUE(:id, :url)", nativeQuery = true)
    void addPhotoUrl(Long id, String url);
}
