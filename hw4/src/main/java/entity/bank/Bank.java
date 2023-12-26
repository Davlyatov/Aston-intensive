package entity.bank;

import entity.AbstractIdentifiableObject;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorColumn
@Getter
@Setter
@Entity
@Table(name = "bank")
public class Bank extends AbstractIdentifiableObject {

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "person_bank",
                joinColumns = @JoinColumn(name = "bank_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"))
    private Set<Person> persons = new HashSet<>();
}
