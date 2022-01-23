package be.jochenhansoul.yummieapp.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
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
    @Column(unique=true)
    private String emailAddress;
    @NotNull
    private boolean isValidated = false;
    @NotNull
    private boolean isMainEmail = false;
    private String description = null;

    public Optional<String> getDescription() {
        return Optional.ofNullable(this.description);
    }
}
