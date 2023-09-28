package attornatus.teste.javajr.repository;

import attornatus.teste.javajr.domain.entities.Address;
import attornatus.teste.javajr.domain.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
