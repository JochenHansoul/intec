package be.jochenhansoul.petstore.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Integer userStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && userName.equals(user.userName) && firstName.equals(user.firstName) && lastName.equals(user.lastName) && email.equals(user.email) && password.equals(user.password) && Objects.equals(phone, user.phone) && userStatus.equals(user.userStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, firstName, lastName, email, password, phone, userStatus);
    }
}
