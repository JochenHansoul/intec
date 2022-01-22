package be.jochenhansoul.yummieapp.model;

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
    private String firstName;
    private String lastName;
    @OneToMany
    private List<Address> addresses;
    @OneToMany
    private List<TelephoneNumber> telephoneNumbers;
    @NotNull
    private String mainEmail;
    private boolean mainEmailIsValidated = false;
    private String mainEmailDescription;
    @OneToMany
    private List<EmailAddress> emailAddresses;
    private String password;
    @OneToOne
    private Location defaultSearchLocation = null;
    private boolean isRestaurantUser = false;

    public Optional<String> getMainEmailDescription() {
        return Optional.ofNullable(this.mainEmailDescription);
    }

    public Optional<Location> getDefaultSearchLocation() {
        return Optional.ofNullable(this.defaultSearchLocation);
    }
}
