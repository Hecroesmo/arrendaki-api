package arreandaki.com.arreandaki.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import arreandaki.com.arreandaki.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
  Person findByIdentifyCardNumber(String identifyCardNumber);
}
