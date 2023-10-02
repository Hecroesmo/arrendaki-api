package arreandaki.com.arreandaki.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import arreandaki.com.arreandaki.model.Locality;
import arreandaki.com.arreandaki.repository.LocalityRepository;

@Component
public class LocalityUtility {
  @Autowired
  private LocalityRepository repo;

  public Locality alterIfNotNull(Locality locality) {
    long pkLocality = locality.getPkLocality();
    if (pkLocality <= 0) {
      return null;
    }

    Locality newLocality = repo.findById(pkLocality).get();
    return newLocality;
  }
}
