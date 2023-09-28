package attornatus.teste.javajr.service;

import attornatus.teste.javajr.domain.dto.PersonAll;
import attornatus.teste.javajr.domain.dto.PersonDto;
import attornatus.teste.javajr.domain.dto.PersonPost;
import attornatus.teste.javajr.domain.dto.PersonPut;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class PersonServiceTest {
    @InjectMocks
    private PersonService personService;
    @Mock
    private PersonRepository personRepository;
    @Mock
    private CityService cityService;
    @Mock
    private AddressRepository addressRepository;
    City city;
    Person person;
    Address address;
    PersonPost personPost;
    PersonDto personDto;
    PersonAll personAll;
    PersonPut personPut;
    Optional<Person> personOpt;

    @BeforeEach
    void setUp() throws ParseException {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void createPerson() {
        when(personRepository.save(any())).thenReturn(person);
        var response = personService.createPerson(personPost);
        assertNotNull(response);
        assertEquals(Person.class, response.getClass());
        assertEquals("ElysonPost", response.getName());
    };

    @Test
    void findByPerson() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        when(personRepository.findById(1L)).thenReturn(personOpt);
        Person person1 = new Person(1L, "ElysonEntity", sdf.parse("25-02-2003"));
        var response = this.personService.findByPerson(1L);
        assertNotNull(response);
        assertEquals(Person.class, response.getClass());
        assertEquals(1L, response.getId());
        assertEquals("ElysonEntity", response.getName());
    }

    @Test
    void testObjNotFound(){
        when(personRepository.findById(Mockito.anyLong())).thenThrow( new ObjectNotFoundException("Error: Person not found."));
        try {
            personService.findByPerson(1L);
        } catch(Exception ex){
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals("Error: Person not found.", ex.getMessage());
        }
    }

    @Test
    void testAddressException(){
        when(personRepository.findById(Mockito.anyLong())).thenThrow( new ObjectNotFoundException("Error: Person not found."));
        try {
            personService.findByPerson(1L);
        } catch(Exception ex){
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals("Error: Person not found.", ex.getMessage());
        }
    }

    @Test
    void changePerson(){
        personPut = new PersonPut("ElysonPut", 1L, 'Y');
        personService.changePerson(1L,personPut);
    }

    @Test
    void findAllPerson() {
        when(personRepository.findAll()).thenReturn(List.of(person));
        var response = personService.findAllPerson();
        assertNotNull(response);
        assertEquals(ArrayList.class, response.getClass());
    }

    private void startUser() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        city = new City(1L, "Barauna");
        person = new Person(1L, "ElysonEntity", sdf.parse("25-02-2003"));
        address = new Address(1L, city, person, "Rua Exemplo", "12345-678", 42L, 'Y');
        personPost = new PersonPost("ElysonPost", sdf.parse("25-02-2003"), 1L, "Rua Exemplo", "12345-678", 42L, 'Y');
        personDto = new PersonDto("ElysonDto", sdf.parse("25-02-2003"));
        personAll = new PersonAll("ElysonAll", sdf.parse("25-02-2003"));
        personPut = new PersonPut("ElysonPut", 1L, 'Y');
        personOpt = Optional.of(person);
    }
}