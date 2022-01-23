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
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Gender gender;
    @NotNull
    private String password;
    @NotNull
    private boolean isActiveRestaurantUser = false;
    @NotNull
    @OneToMany
    private List<EmailAddress> emailAddresses;
    @OneToMany
    private List<Address> addresses;
    @OneToMany
    private List<TelephoneNumber> telephoneNumbers;
    @OneToOne
    private Location defaultSearchLocation = null;

    public Optional<Location> getDefaultSearchLocation() {
        return Optional.ofNullable(this.defaultSearchLocation);
    }
}
