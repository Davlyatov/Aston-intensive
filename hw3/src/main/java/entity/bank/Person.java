package entity.bank;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "full_name")
    private String full_name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "person_bank",
            joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "bank_id", referencedColumnName = "id"))
    private Set<Bank> banks = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}
