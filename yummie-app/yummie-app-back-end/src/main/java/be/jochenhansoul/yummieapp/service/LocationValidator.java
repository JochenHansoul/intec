package be.jochenhansoul.yummieapp.service;

import be.jochenhansoul.yummieapp.model.general.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationValidator {

    public boolean validateLocation(Location location) {
        return validateCoordinate(location.getLatitude(), 90F)
                && validateCoordinate(location.getLongitude(), 180F);
    }

    private boolean validateCoordinate(float coordinate, float range) {
        return Math.abs(coordinate) <= range;
    }
}
