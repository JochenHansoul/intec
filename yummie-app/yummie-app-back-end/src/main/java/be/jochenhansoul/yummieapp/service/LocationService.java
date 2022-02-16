package be.jochenhansoul.yummieapp.service;

import be.jochenhansoul.yummieapp.model.general.Location;
import be.jochenhansoul.yummieapp.repository.LocationRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LocationService {

    private final LocationRepository LOCATION_REPOSITORY;
    private final LocationValidator LOCATION_VALIDATOR;

    public LocationService(LocationRepository locationRepository, LocationValidator locationValidator) {
        this.LOCATION_REPOSITORY = locationRepository;
        this.LOCATION_VALIDATOR = locationValidator;
    }

    public Optional<Location> saveLocation(Location location) {
        return this.LOCATION_VALIDATOR.validateLocation(location)
                ? Optional.of(this.LOCATION_REPOSITORY.save(location))
                : Optional.empty();
    }
}
