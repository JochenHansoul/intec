package be.jochenhansoul.yummieapp.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Optional;

@Entity
@Setter
@Getter
@Accessors(chain = true)
public class EmailAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmailAddress;
    @NotNull
    private String emailAddress;
    private boolean isValidated = false;
    private String description = null;

    public Optional<String> getDescription() {
        if (this.description == null) {
            return Optional.empty();
        } else {
            return Optional.of(this.description);
        }
    }
}
