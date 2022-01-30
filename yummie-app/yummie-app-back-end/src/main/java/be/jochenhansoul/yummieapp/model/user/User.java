package be.jochenhansoul.yummieapp.model.user;

import be.jochenhansoul.yummieapp.model.general.Location;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity
@Setter
@Getter
@Accessors(chain = true)
@ToString
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
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @NotNull
    @OneToMany
    private List<Email> emails = new ArrayList<>();
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @OneToMany
    private List<UserAddress> addresses  = new ArrayList<>();
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @OneToMany
    private List<Telephone> telephones  = new ArrayList<>();
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @OneToOne
    private Location defaultSearchLocation = null;
    @NotNull
    private LocalDate creationDate;
    @NotNull
    private boolean isActive = true;

    public User addEmail(Email email) {
        this.emails.add(email);
        return this;
    }

    public void addAddress(UserAddress address) {
        this.addresses.add(address);
    }

    public void addTelephone(Telephone telephone) {
        this.telephones.add(telephone);
    }

    public void setDefaultSearchLocation(Location location) {
        this.defaultSearchLocation = location;
    }

    public List<Email> getEmails() {
        return new ArrayList<>(this.emails);
    }

    public Email getDefaultEmail() {
        return this.emails.stream()
                .filter(Email::isMainEmail)
                .collect(Collectors.toList()).get(0);
    }

    public List<UserAddress> getAddresses() {
        return new ArrayList<>(this.addresses);
    }

    public List<Telephone> getTelephones() {
        return new ArrayList<>(this.telephones);
    }

    public Optional<Location> getDefaultSearchLocation() {
        return Optional.ofNullable(this.defaultSearchLocation);
    }

    public boolean verifyEmail(Email email) {
        return false;
        //this.emails.contains(email);
    }
}
