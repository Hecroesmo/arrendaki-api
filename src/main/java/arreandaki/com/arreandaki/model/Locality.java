package arreandaki.com.arreandaki.model;

import java.io.Serializable;

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
public class Locality implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "pk_locality")
  private Long pkLocality;

  @Column(nullable = false)
  private String designation;

  private boolean isDistrict;

  @ManyToOne(optional = true, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
  @JoinColumn(name = "fk_locality")
  private Locality fkLocality;
}
