package t02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

  @GetMapping("/user/{id}")
  public User handle(@PathVariable Integer id) {
    throw new IllegalArgumentException("implementation doesn't matter");
  }

}
