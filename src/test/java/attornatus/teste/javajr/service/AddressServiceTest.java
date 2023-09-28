package attornatus.teste.javajr.service;

import attornatus.teste.javajr.domain.dto.*;
import attornatus.teste.javajr.domain.entities.Address;
import attornatus.teste.javajr.domain.entities.City;
import attornatus.teste.javajr.domain.entities.Person;
import attornatus.teste.javajr.repository.AddressRepository;
import attornatus.teste.javajr.repository.PersonRepository;
import attornatus.teste.javajr.service.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class AddressServiceTest {

    @InjectMocks
    private AddressService addressService;
    @Mock
    private AddressRepository addressRepository;
    @Mock
    private CityService cityService;
    @Mock
    private PersonService personService;
    City city;
    Person person;
    Address address;
    Optional<Address> addressOptional;
    AddressPost addressPost;

    @BeforeEach
    void setUp() throws ParseException {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void findByAddress() {
        when(addressRepository.findById(any())).thenReturn(addressOptional);
        var response = addressService.findByAddress(1L);
        assertNotNull(response);
        assertEquals("Rua Exemplo", response.getStreet());
    }

    public void startUser() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        city = new City(1L, "Barauna");
        person = new Person(1L, "ElysonEntity", sdf.parse("25-02-2003"));
        address = new Address(1L, city, person, "Rua Exemplo", "12345-678", 42L, 'Y');
        addressPost = new AddressPost(1L, 1L, 1L, "Rua Exemplo", "12345-678", 42L, 'Y');
        addressOptional = Optional.of(address);
    }
}