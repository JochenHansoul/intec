package be.jochenhansoul.petstore.repository;

import be.jochenhansoul.petstore.model.PetOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PetOrderRepository extends JpaRepository<PetOrder, Long> {
    @Query("SELECT p FROM PetOrder p WHERE p.id = :id")
    PetOrder getById(Long id);

    void deleteById(Long id);
}
