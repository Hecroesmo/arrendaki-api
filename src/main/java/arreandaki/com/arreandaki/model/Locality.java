package arreandaki.com.arreandaki.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Locality {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "pk_locality")
  private Long pkLocality;
  private String designation;
  @ManyToOne(optional = true, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
  @JoinColumn(name = "fk_locality")
  private Locality fkLocality;
}
