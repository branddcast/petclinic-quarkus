package pl.codeleak.samples.petclinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "owners")
public class Owner extends Person{
    @Column(name = "address")
    @NotEmpty
    protected String address;

    @Column(name = "city")
    @NotEmpty
    protected String city;

    @Column(name = "telephone")
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    protected String telephone;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Pet> pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}