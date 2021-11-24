package be.jochenhansoul.petstore.repository;

import be.jochenhansoul.petstore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
