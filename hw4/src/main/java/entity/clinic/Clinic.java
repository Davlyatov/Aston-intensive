package entity.clinic;

import entity.AbstractIdentifiableObject;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorColumn
@Getter
@Setter
@Entity
@Table(name = "clinic")
public class Clinic extends AbstractIdentifiableObject {

    private String name;

    private String address;
}
