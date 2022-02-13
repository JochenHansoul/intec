package be.jochenhansoul.yummieapp.model.person;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

//@Entity
@Setter
@Getter
@Accessors(chain = true)
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAddress;
    private String country;
    private String zipCode;
    private String street;
    private String number;
    private boolean mainAddress;
}
