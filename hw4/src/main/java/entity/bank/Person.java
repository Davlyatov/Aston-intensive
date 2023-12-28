package entity.bank;

import entity.AbstractIdentifiableObject;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorColumn
@Getter
@Setter
@Entity
@Table(name = "person")
public class Person extends AbstractIdentifiableObject {

    private String full_name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "person_bank",
            joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "bank_id", referencedColumnName = "id"))
    private Set<Bank> banks = new HashSet<>();
}
