package be.jochenhansoul.yummieapp.model.restaurant;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalTime;

@Entity
@Setter
@Getter
@Accessors(chain = true)
public class MomentOpen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMomentOpen;
    private LocalTime open;
    private LocalTime closed;
}