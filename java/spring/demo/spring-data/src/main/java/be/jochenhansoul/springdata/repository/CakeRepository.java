package be.jochenhansoul.springdata.repository;

import be.jochenhansoul.springdata.model.Cake;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CakeRepository extends JpaRepository<Cake, Integer> {
    List<Cake> findCakeBySize(Integer size);
}
