package be.jochenhansoul.yummieapp.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.List;

@Entity
@Setter
@Getter
@Accessors(chain = true)
public class OpenHour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private DayOfWeek day;
    @OneToMany
    private List<MomentOpen> momentsOpen;
}
