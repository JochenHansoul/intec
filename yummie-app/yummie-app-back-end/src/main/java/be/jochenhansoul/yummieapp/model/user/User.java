package be.jochenhansoul.yummieapp.model.user;

import be.jochenhansoul.yummieapp.model.general.Location;
import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Gender gender;
    @NotNull
    private LocalDate birthDate;
    @NotNull
    //@Column(unique = true)
    private String email;
    @NotNull
    private String password;
    @NotNull
    private boolean isRestaurantUser = false;
    @NotNull
    private LocalDate creationDate = LocalDate.now();
    @NotNull
    private boolean isValidated = false;
    @OneToOne
    private UserAddress address  = null;
    private String telephone  = null;
    @OneToOne
    private Location defaultSearchLocation = null;

    public User(User user) {
        this.userId = user.userId;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.gender = user.gender;
        this.birthDate = user.birthDate;
        this.email = user.email;
        this.password = user.password;
        this.isRestaurantUser = user.isRestaurantUser;
        this.creationDate = user.creationDate;
        this.isValidated = user.isValidated;
        this.address  = user.address;
        this.telephone  = user.telephone;
        this.defaultSearchLocation = user.defaultSearchLocation;
    }
}
