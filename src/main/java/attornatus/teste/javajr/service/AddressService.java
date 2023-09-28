package attornatus.teste.javajr.service;

import attornatus.teste.javajr.domain.dto.AddressPost;
import attornatus.teste.javajr.domain.entities.Address;
import attornatus.teste.javajr.domain.entities.City;
import attornatus.teste.javajr.domain.entities.Person;
import attornatus.teste.javajr.repository.AddressRepository;
import attornatus.teste.javajr.repository.PersonRepository;
import attornatus.teste.javajr.service.exceptions.AddressException;
import attornatus.teste.javajr.service.exceptions.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private CityService cityService;

    private final Logger logger = LoggerFactory.getLogger(AddressService.class);

    public Address createAddress(AddressPost address){
        logger.info("** SERVICE :: Creating address and convert DTO to Entity **");
        Address newAddress = fromDto(address);
        addressRepository.save(newAddress);
        personRepository.save(newAddress.getPerson());
        return newAddress;
    }

    public Address findByAddress(Long id){logger.error("** SERVICE :: Shearching address by ID **");
      Optional<Address> address = addressRepository.findById(id);
      if(address.isPresent()) return address.get();
      else throw new ObjectNotFoundException("Error: Address not found");
    }

    public List<Address> findAllAddress(Long id) {
        logger.info("** SERVICE :: People found **");
        List<Address> addresses = personService.findByPerson(id).getAdresses();
        if(addresses.isEmpty()) throw new ObjectNotFoundException("Error: Person not address or person not found.");
        else return addresses;
    }

    private Address fromDto(AddressPost addressPost) {
        Person person = personService.findByPerson(addressPost.getPersonId());
        City city = cityService.findCityByID(addressPost.getCity());
        Address address = new Address(null, city, person, addressPost.getStreet(), addressPost.getZipcode(), addressPost.getNumber(), addressPost.getPriorityAddress());
        findPriorityAddress(person, addressPost);
        validatePriority(addressPost);
        return address;
    }

    private void validatePriority(AddressPost addressPost) {
        logger.info("** SERVICE :: Validating address priority **");
        if(isValidPriority(addressPost)){
            logger.error("** SERVICE :: Error a validation **");
            throw new AddressException("Error: use Y for true and N for false.");
        }
    }

    private boolean isValidPriority(AddressPost addressPost) {
        return addressPost.getPriorityAddress() != 'Y' && addressPost.getPriorityAddress() != 'N';
    }

    private void findPriorityAddress(Person person1, AddressPost addressPost){
        logger.info("** SERVICE :: Sheaching address priority **");
        for(Address x : person1.getAdresses()){
            if (x.getPriorityAddress()=='Y' && addressPost.getPriorityAddress()=='Y') {
                throw new AddressException("Error: Address is priority");
            }
        }
    }
}
