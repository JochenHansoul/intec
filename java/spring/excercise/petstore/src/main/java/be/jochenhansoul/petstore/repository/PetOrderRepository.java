package be.jochenhansoul.petstore.repository;

import be.jochenhansoul.petstore.model.PetOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetOrderRepository extends JpaRepository<PetOrder, Long> {
    PetOrder getById(Long id);

    void deleteById(Long id);
}
