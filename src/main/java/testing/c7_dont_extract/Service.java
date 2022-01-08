package testing.c7_dont_extract;

import testing.lombok.Person;

import java.util.List;
import java.util.Optional;

public class Service {

  public Optional<Person> nextOpt() {
    return Optional.ofNullable(next());
  }

  public Person next() {
    if ((int)(Math.random() * 2) == 0) return null;
    int id = (int)(Math.random() * 100);
    return new Person(id, "MOCKED: "+id, List.of());
  }

}
