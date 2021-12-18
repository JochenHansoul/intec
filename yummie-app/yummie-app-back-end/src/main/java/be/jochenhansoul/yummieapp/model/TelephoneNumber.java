package be.jochenhansoul.yummieapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@Accessors(chain = true)
public class TelephoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTelephoneNumber;
    private String description;
    private long number;
}