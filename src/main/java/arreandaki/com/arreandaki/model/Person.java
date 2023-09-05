package arreandaki.com.arreandaki.model;

import java.util.Date;

import lombok.Data;

@Data
public class Person {
  private String firstName;
  private String lastName;
  private Date birthDate;
}
