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
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idContact;
    private long mainTelephone;
    @OneToMany
    private List<TelephoneNumber> telephoneNumbers;
    private String mainEmail;
    @OneToMany
    private List<EmailAddress> emailAddresses;
}
