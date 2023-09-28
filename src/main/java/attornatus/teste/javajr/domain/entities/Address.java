package attornatus.teste.javajr.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Table(name = "tb_address")
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    private String street;
    private String zipcode;
    private Long number;
    private Character priorityAddress = 'N';

    public Address(Long id, City city, Person person, String street, String zipcode, Long number, Character priorityAddress) {
        this.id = id;
        this.city = city;
        this.person = person;
        this.street = street;
        this.zipcode = zipcode;
        this.number = number;
        this.priorityAddress = priorityAddress;
    }

    public Address(Long id, City city, String street, String zipcode, Long number, Character priorityAddress) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.number = number;
        this.priorityAddress = priorityAddress;
    }

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Character getPriorityAddress() {
        return priorityAddress;
    }

    public void setPriorityAddress(Character priorityAddress) {
        this.priorityAddress = priorityAddress;
    }
}

