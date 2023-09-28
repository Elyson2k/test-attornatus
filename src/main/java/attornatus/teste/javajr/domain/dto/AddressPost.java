package attornatus.teste.javajr.domain.dto;

import javax.validation.constraints.NotEmpty;

public class AddressPost {

    private Long id;
    @NotEmpty
    private Long city;
    private Long personId;
    @NotEmpty
    private String street;
    @NotEmpty
    private String zipcode;
    @NotEmpty
    private Long number;
    @NotEmpty
    private Character priorityAddress;

    public AddressPost(Long id, Long city, Long personId, String street, String zipcode, Long number, Character priorityAddress) {
        this.id = id;
        this.city = city;
        this.personId = personId;
        this.street = street;
        this.zipcode = zipcode;
        this.number = number;
        this.priorityAddress = priorityAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
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
