package be.jochenhansoul.yummieapp.model.user;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Objects;
import java.util.Optional;

//@Entity
@Setter
@Getter
@Accessors(chain = true)
@ToString
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmail;
    @NotNull
    @Column(unique=true)
    private String emailAddress;
    @NotNull
    private boolean validated = false;
    @NotNull
    private boolean mainEmail = false;
    private String description = null;

    public Optional<String> getDescription() {
        return Optional.ofNullable(this.description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return idEmail == email.idEmail && emailAddress.equals(email.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmail, emailAddress);
    }
}
