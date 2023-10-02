package arreandaki.com.arreandaki.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import arreandaki.com.arreandaki.model.Locality;
import arreandaki.com.arreandaki.model.Person;
import arreandaki.com.arreandaki.repository.LocalityRepository;
import arreandaki.com.arreandaki.repository.PersonRepository;
import arreandaki.com.arreandaki.utility.LocalityUtility;
import arreandaki.com.arreandaki.utility.PersonUtility;

@RestController
@RequestMapping("/persons")
public class PersonController {
  @Autowired
  private PersonRepository personRepo;

  @Autowired
  private LocalityRepository localityRepo;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Iterable<Person> findAll() {
    return personRepo.findAll();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Person save(@RequestBody Person person) {
    return personRepo.save(person);
  }

  @PatchMapping("/{pkPerson}")
  @ResponseStatus(HttpStatus.CREATED)
  public Person alter(@PathVariable long pkPerson, @RequestBody Person newPerson) {
    Person person = personRepo.findById(pkPerson).get();
    person = PersonUtility.alterIfNotNull(person, newPerson);

    Locality newLocality = new LocalityUtility()
        .alterIfNotNull(newPerson.getFkLocality());

    if (newLocality == null) {
      person.setFkLocality(newLocality);
    }
    return personRepo.save(person);
  }

}
