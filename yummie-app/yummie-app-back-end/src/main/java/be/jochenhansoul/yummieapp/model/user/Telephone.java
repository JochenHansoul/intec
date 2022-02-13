package be.jochenhansoul.yummieapp.model.user;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Optional;

//@Entity
@Setter
@Getter
@Accessors(chain = true)
public class Telephone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTelephone;
    private long number;
    private boolean validated = false;
    private String description = null;

    public Optional<String> getDescription() {
        return Optional.ofNullable(this.description);
    }
}
