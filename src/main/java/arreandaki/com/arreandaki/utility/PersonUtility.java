package arreandaki.com.arreandaki.utility;

import arreandaki.com.arreandaki.model.Person;

public class PersonUtility {
  public static Person alterIfNotNull(Person person, Person newPerson) {
    if (newPerson.getBirthDate() != null) {
      person.setBirthDate(newPerson.getBirthDate());
    }

    if (newPerson.getFullName() != null) {
      person.setFullName(newPerson.getFullName());
    }

    if (newPerson.getPhoneNumber() != null) {
      person.setPhoneNumber(newPerson.getPhoneNumber());
    }

    if (newPerson.getIdentifyCardNumber() != null) {
      person.setIdentifyCardNumber(newPerson.getIdentifyCardNumber());
    }

    return person;
  }
}