package be.jochenhansoul.petstore.repository;

import be.jochenhansoul.petstore.model.Pet;
import be.jochenhansoul.petstore.model.PetStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    @Query("SELECT p FROM Pet p WHERE p.id = :id")
    Pet getPetById(Long id);

    void deleteById(Long id);

    List<Pet> getPetsByStatus(PetStatus status);

    @Modifying
    @Query("UPDATE Pet p SET p.name = :name WHERE p.id = :id")
    int updatePet(Long id, String name);

    @Modifying
    @Query("UPDATE Pet p SET p.status = :status WHERE p.id = :id")
    int updatePet(Long id, PetStatus status);

    // native query
    // use a native query since INSERT is not a part of the JPA interface
    @Modifying
    @Query(value = "INSERT INTO pet_photo_urls VALUE(:id, :url)", nativeQuery = true)
    void addPhotoUrl(Long id, String url);
}
