package be.jochenhansoul.yummieapp.repository;

import be.jochenhansoul.yummieapp.model.general.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
