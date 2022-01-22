package be.jochenhansoul.yummieapp.model;

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
public class TelephoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTelephoneNumber;
    private long number;
    private boolean isValidated = false;
    private String description = null;

    public Optional<String> getDescription() {
        return Optional.ofNullable(this.description);
    }
}
