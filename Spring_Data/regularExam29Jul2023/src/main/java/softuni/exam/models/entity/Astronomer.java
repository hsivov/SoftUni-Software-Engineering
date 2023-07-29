package softuni.exam.models.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "astronomers")
public class Astronomer extends BaseEntity{

    @Column(nullable = false, name = "first_name")
    private String firstName;
    @Column(nullable = false, name = "last_name")
    private String lastName;
    @Column(nullable = false)
    private Double salary;
    @Column(nullable = false)
    private Double averageObservationHours;
    @Column(name = "birthday")
    private LocalDate birthDay;

    @ManyToOne
    @JoinColumn(name = "observing_star_id")
    private Star observingStar;

    public Star getObservingStar() {
        return observingStar;
    }

    public void setObservingStar(Star observingStar) {
        this.observingStar = observingStar;
    }
}
