package be.jochenhansoul.yummieapp.model.user;

import be.jochenhansoul.yummieapp.model.general.Location;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Setter
@Getter
@Accessors(chain = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Gender gender;
    @NotNull
    private String password;
    @NotNull
    private boolean isRestaurantUser = false;
    @NotNull
    @OneToMany
    private List<Email> emails;
    @OneToMany
    private List<Address> addresses;
    @OneToMany
    private List<Telephone> telephones;
    @OneToOne
    private Location defaultSearchLocation = null;

    public Optional<Location> getDefaultSearchLocation() {
        return Optional.ofNullable(this.defaultSearchLocation);
    }
}
