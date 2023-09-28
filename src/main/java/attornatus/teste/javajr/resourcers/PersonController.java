package attornatus.teste.javajr.resourcers;

import attornatus.teste.javajr.domain.dto.PersonAll;
import attornatus.teste.javajr.domain.dto.PersonDto;
import attornatus.teste.javajr.domain.dto.PersonPost;
import attornatus.teste.javajr.domain.dto.PersonPut;
import attornatus.teste.javajr.domain.entities.Person;
import attornatus.teste.javajr.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    private final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonDto> findPerson(@PathVariable Long id) {
        logger.info("*** CONTROLLER :: Searching for PERSON by ID = {}. ***", id);
        Person person = personService.findByPerson(id);
        PersonDto personDto = new PersonDto(person.getName(),person.getBirthDate());
        personDto.setAdresses(person.getAdresses());
        logger.info("*** CONTROLLER :: Person found. ***");
        return ResponseEntity.ok(personDto);
    }

    @GetMapping
    public ResponseEntity<List<PersonAll>> findPersonAll(){
        logger.info("*** CONTROLLER :: Looking for all people. ***");
        return ResponseEntity.ok(personService.findAllPerson());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePerson(@PathVariable Long id, @RequestBody PersonPut person) {
        logger.info("*** CONTROLLER :: Updating person by ID={} ***", id);
        personService.changePerson(id,person);
        logger.info("*** CONTROLLER :: Person update finish. ***");
        return ResponseEntity.ok().build();
    }

    @PostMapping("/insert")
    public ResponseEntity<Void> insertPerson(@RequestBody PersonPost person){
        logger.info("*** CONTROLLER :: Inserting person = {} ***", person);
        var id = personService.createPerson(person).getId();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        logger.info("*** CONTROLLER :: Inserting person finish ***");
        return ResponseEntity.created(uri).build();
    }
}
