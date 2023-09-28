package attornatus.teste.javajr;

import attornatus.teste.javajr.domain.entities.Address;
import attornatus.teste.javajr.domain.entities.City;
import attornatus.teste.javajr.domain.entities.Person;
import attornatus.teste.javajr.repository.AddressRepository;
import attornatus.teste.javajr.repository.CityRepository;
import attornatus.teste.javajr.repository.PersonRepository;
import net.bytebuddy.build.Plugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class JavajrApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JavajrApplication.class, args);
	}

	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private AddressRepository addressRepository;

	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	@Override
	public void run(String... args) throws Exception {
		City city1 = new City(null, "Barauna");
		City city2 = new City(null, "Mossoro");
		City city3 = new City(null, "Natal");
		City city4 = new City(null, "Fortaleza");
		City city5 = new City(null, "Tibau");

		Person person = new Person(1L, "Carlos Alberto", sdf.parse("25-02-2003"));

		Address address = new Address(1L, city1, person, "Rua Tal", "0000000", 5L, 'Y');

		cityRepository.saveAll(Arrays.asList(city1,city2,city3,city4,city5));
		personRepository.save(person);
		addressRepository.save(address);
	}
}
