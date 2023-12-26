package entity.clinic;

import entity.AbstractIdentifiableObject;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@DiscriminatorColumn
@Table(name = "doctors")
public class Doctor extends AbstractIdentifiableObject {

    private String name;

    private String profession;

    @ManyToOne
    private Clinic clinic;
}
