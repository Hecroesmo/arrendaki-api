package arreandaki.com.arreandaki.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
  @GetMapping("/hello")
  public String helloWorld() {
    return "Hello World";
  }

  @GetMapping("/hello/{name}")
  public String sayHi(@PathVariable String name) {
    return "Hi! " + name;
  }
}
