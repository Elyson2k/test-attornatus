package attornatus.teste.javajr.domain.dto;

import attornatus.teste.javajr.domain.entities.Person;

import java.util.Date;

public class PersonAll {

    private String name;
    private Date birthDate;



    public PersonAll(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public static PersonAll toDto(Person person) {
        return new PersonAll(person.getName(), person.getBirthDate());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBithDate() {
        return birthDate;
    }

    public void setBithDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
