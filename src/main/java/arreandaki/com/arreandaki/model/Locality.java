package arreandaki.com.arreandaki.model;

import lombok.Data;

@Data
public class Locality {
  private Long pkLocality;
  private String designation;
  private Locality fkLocality;
}
