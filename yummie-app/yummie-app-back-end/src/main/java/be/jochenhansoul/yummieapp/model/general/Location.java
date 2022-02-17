package be.jochenhansoul.yummieapp.model.general;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class Location {
    private static final double EARTH_RADIUS_KM = 6371;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocation;
    @NotNull
    private double latitude;
    @NotNull
    private double longitude;

    public Location(double latitude, double longitude) {
        this.idLocation = null;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getDistance(Location location) {
        // got this from Cletus on stackoverflow
        // source: https://stackoverflow.com/questions/365826/calculate-distance-between-2-gps-coordinates
        double dLat = Math.toRadians(location.latitude - this.latitude);
        double dLon = Math.toRadians(location.longitude - this.longitude);
        double latitudeOwn = Math.toRadians(this.latitude);
        double latitudeOther = Math.toRadians(location.latitude);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(latitudeOwn) * Math.cos(latitudeOther);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); // c means rad
        return EARTH_RADIUS_KM * c;
    }
}
