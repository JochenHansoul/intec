package be.jochenhansoul.petstore.repository;

import be.jochenhansoul.petstore.model.Pet;
import be.jochenhansoul.petstore.model.PetStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    Pet getById(Long id);

    void deleteById(Long id);

    List<Pet> getPetsByStatus(PetStatus status);

    @Query("UPDATE Pet p SET p.name = :name, p.status = :status WHERE p.id = :id")
    Pet updatePet(Long id, String name, PetStatus status);

    // native query
    @Query(value = "INSERT INTO pet_photo_urls VALUE(:id, :url)", nativeQuery = true)
    void addPhotoUrl(Long id, String url);
}
