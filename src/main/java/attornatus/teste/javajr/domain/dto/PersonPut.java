package attornatus.teste.javajr.domain.dto;

import javax.validation.constraints.NotEmpty;

public class PersonPut {

    @NotEmpty
    private String name;
    private Long addressId;
    private Character priorityAddress;

    public PersonPut(String name, Long addressId, Character priorityAddress) {
        this.name = name;
        this.addressId = addressId;
        this.priorityAddress = priorityAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Character getPriorityAddress() {
        return priorityAddress;
    }

    public void setCharacter(Character priorityAddress) {
        this.priorityAddress = priorityAddress;
    }
}
