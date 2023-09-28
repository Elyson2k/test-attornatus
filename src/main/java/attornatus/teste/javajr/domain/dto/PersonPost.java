package attornatus.teste.javajr.domain.dto;

import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class PersonPost {


    @NotEmpty
    private String name;
    @NotEmpty
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth", nullable = false)
    private Date birthDate;
    @NotEmpty
    private Long cityId;

    @NotEmpty
    private String street;

    @NotEmpty
    private String zipcode;

    @NotEmpty
    private Long number;

    @NotEmpty
    private Character priorityAddress;

    public PersonPost(String name, Date birthDate, Long cityId, String street, String zipcode, Long number, Character priorityAddress) {
        this.name = name;
        this.birthDate = birthDate;
        this.cityId = cityId;
        this.street = street;
        this.zipcode = zipcode;
        this.number = number;
        this.priorityAddress = priorityAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
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

    @Override
    public String toString() {
        return "PersonPost{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", cityId=" + cityId +
                ", street='" + street + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", number=" + number +
                ", priorityAddress=" + priorityAddress +
                '}';
    }
}
