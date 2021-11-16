package be.jochenhansoul.springdata.repository;

import be.jochenhansoul.springdata.model.Cake;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CakeRepository extends JpaRepository<Cake, Integer> {
}
