package pl.codeleak.samples.petclinic.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "pets")
public class Pet extends NamedEntity{
    @Column(name = "birth_date")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "type_id")
    @JsonIgnore
    private PetType type;

    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "owner_id")
    @JsonIgnore
    private Owner owner;

    @OneToMany(cascade =  CascadeType.ALL, mappedBy = "pet", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Visit> visits;

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
        this.type = type;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }
}