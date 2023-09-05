package arreandaki.com.arreandaki.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import arreandaki.com.arreandaki.model.Locality;
import arreandaki.com.arreandaki.repository.LocalityRepository;

@RestController
@RequestMapping("/localities")
public class LocalityController {
  @Autowired
  LocalityRepository localityRepo;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Iterable<Locality> findAll() {
    return localityRepo.findAll();
  }

  @GetMapping("/{pkLocality}")
  @ResponseStatus(HttpStatus.OK)
  public Locality findById(@PathVariable long pkLocality) {
    return localityRepo.findById(pkLocality).get();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Locality save(@RequestBody Locality newLocality) {
    return localityRepo.save(newLocality);
  }

  @PatchMapping("/{pkLocality}")
  @ResponseStatus(HttpStatus.OK)
  public Locality alter(@PathVariable long pkLocality, @RequestBody Locality newLocality) {
    Locality locality = localityRepo.findById(pkLocality).get();
    locality.setDesignation(newLocality.getDesignation());
    return localityRepo.save(locality);
  }

  @DeleteMapping("/{pkLocality}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable long pkLocality) {
    System.err.println("pkLocality: " + pkLocality);
    localityRepo.deleteById(pkLocality);
  }

}
