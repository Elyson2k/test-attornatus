package attornatus.teste.javajr.resourcers;

import attornatus.teste.javajr.domain.dto.AddressPost;
import attornatus.teste.javajr.domain.entities.Address;
import attornatus.teste.javajr.service.AddressService;
import attornatus.teste.javajr.service.exceptions.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    private final Logger logger = LoggerFactory.getLogger(AddressController.class);

    @GetMapping("/{id}")
    public ResponseEntity<Address> findAddress(@PathVariable Long id) throws Throwable {
        logger.info("*** CONTROLLER :: Searching addresses by ID = {} ***", id);
        var address = addressService.findByAddress(id);
        logger.info("*** CONTROLLER :: Searching finish ***");
        return ResponseEntity.ok(address);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<List<Address>> findPersonAddress(@PathVariable Long id){
        logger.info("*** CONTROLLER :: Searching for all addresses of a person ***");
        var listAddressOfPerson = addressService.findAllAddress(id);
        logger.info("*** CONTROLLER :: Searching finish ***");
        return ResponseEntity.ok(listAddressOfPerson);
    }

    @PostMapping("/insertAddress")
    public ResponseEntity<Void> insertAddress(@RequestBody AddressPost addressPost) throws ObjectNotFoundException {
        logger.info("*** CONTROLLER :: Creating address ***");
        var id = addressService.createAddress(addressPost).getId();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        logger.info("*** CONTROLLER :: Address created ***");
        return ResponseEntity.created(uri).build();
    }
}
