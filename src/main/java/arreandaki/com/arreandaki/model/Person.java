package arreandaki.com.arreandaki.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString
@Entity
public class Person implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "pk_person")
  private Long pkPerson;

  @Column(name = "full_name")
  private String fullName;

  @Column(name = "identify_card_number")
  private String identifyCardNumber;

  @Column(name = "phone_number")
  private String phoneNumber;

  @Column(name = "birth_date")
  private Date birthDate;

  @ManyToOne(optional = false, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
  @JoinColumn(name = "fk_locality")
  private Locality fkLocality;
}
