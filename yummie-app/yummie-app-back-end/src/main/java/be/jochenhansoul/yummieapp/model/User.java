package be.jochenhansoul.yummieapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

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
    @OneToMany
    private List<EmailAddress> emailAddresses;
    private boolean isRestaurantUser = false;
    private String password;
    @OneToOne
    private Location defaultSearchLocation;
}
