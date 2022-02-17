package be.jochenhansoul.yummieapp.service;

import be.jochenhansoul.yummieapp.model.general.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationValidator {

    public boolean validateLocation(Location location) {
        return validateCoordinate(location.getLatitude(), 90)
                && validateCoordinate(location.getLongitude(), 180);
    }

    private boolean validateCoordinate(double coordinate, double range) {
        return Math.abs(coordinate) <= range;
    }
}
