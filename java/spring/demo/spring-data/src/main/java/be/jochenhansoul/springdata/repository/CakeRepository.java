package be.jochenhansoul.springdata.repository;

import be.jochenhansoul.springdata.model.Cake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CakeRepository extends JpaRepository<Cake, Integer> {
    List<Cake> findCakeBySize(Integer size);

    @Query("SELECT c FROM Cake c WHERE c.name LIKE :name")
    List<Cake> findSomeCake(String name);
}
